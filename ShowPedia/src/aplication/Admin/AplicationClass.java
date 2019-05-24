package aplication.Admin;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import character.object.Personagem;
import character.object.PersonagemClass;
import exceptions.All.CharacterExistException;
import exceptions.All.EmptyCollectionException;
import exceptions.All.ExistShowException;
import exceptions.All.InexistentEpisodeNumber;
import exceptions.All.InexistentSeasonException;
import exceptions.All.NegativeNumException;
import exceptions.All.NonExistentActor;
import exceptions.All.NotExistShowException;
import exceptions.All.RepeatedRelationShip;
import exceptions.All.SameCharacterException;
import exceptions.All.UnknownActorTypeException;
import object.Actor.Actor;
import object.Actor.RealActor;
import object.Actor.RealActorClass;
import object.Actor.VirtualActorClass;
import object.Episode.Episode;
import object.Event.Event;
import object.Event.EventClass;
import object.Quote.Quote;
import object.Quote.QuoteClass;
import object.Show.Show;
import object.Show.ShowClass;

public class AplicationClass implements Aplication {

	private static final String REAL = "REAL";
	private static final String VIRTUAL = "VIRTUAL";
	private Map<String, Show> shows;
	private Map<String, LinkedList<Actor>> actorsPerShow; // a show has a collection of actors making the show
	private Map<String, List<Show>> showsPerActors; // an has a collection of shows in which he has participated
	private List<Actor> actorsCollection; // the application registry of all the actors
	private Map<String, Actor> virtualActors; // only virtual actors
	private Map<String, List<Quote>> quotesPerCharacters;
	private Show currentShow;
	private String currentShowName;

	public AplicationClass() {
		shows = new HashMap<String, Show>();
		actorsCollection = new ArrayList<>();
		actorsPerShow = new TreeMap<String, LinkedList<Actor>>();
		virtualActors = new TreeMap<>();
		showsPerActors = new TreeMap<>();
		quotesPerCharacters = new TreeMap<>();
		currentShow = null;
		currentShowName = null;
	}

	public void addShow(String showName) throws ExistShowException {
		if (shows.containsKey(showName)) {
			throw new ExistShowException();
		} else {
			Show s = new ShowClass(showName);
			LinkedList<Actor> actors = new LinkedList<>();
			actorsPerShow.put(showName, actors);
			shows.put(showName, s);
		}
	}

	public boolean isThereSelectedShow() {
		return currentShow != null;
	}

	public String getCurrentShow() throws NotExistShowException {
		if (currentShow == null) {
			throw new NotExistShowException();
		}
		int numberOfEpisodes = currentShow.getAllEpisodesNumber();
		return String.format("%s. Seasons: %d Episodes: %d", currentShow.getShowName(),
				currentShow.getNumberOfSeasons(), numberOfEpisodes);
	}

	public Show getCurrentShowObject() {
		return currentShow;
	}

	public void switchToShow(String showName) throws NotExistShowException {
		if (mapContainsThisKey(showName)) {
			currentShow = shows.get(currentShowName);
		} else {
			throw new NotExistShowException();
		}
	}

	public void addSeason() throws NotExistShowException {
		if (isThereSelectedShow()) {
			currentShow.addSeason();
		} else {
			throw new NotExistShowException();
		}
	}

	public String addEpisode(int seasonNumber, String episodeName) throws NotExistShowException {
		if (!isThereSelectedShow()) {
			throw new NotExistShowException("NOSHOW");
		} else if (!currentShow.getEpisodesPerSeason().containsKey(seasonNumber)) {
			throw new NotExistShowException("NOSEASON");
		} else {
			currentShow.addEpisodeToSeason(seasonNumber, episodeName);
			return String.format("%s S%d, Ep%d: %s.", currentShow.getShowName(), seasonNumber,
					currentShow.getEpisodesPerSeason().get(seasonNumber).size(), episodeName);
		}

	}

	public String addCharacter(String characterName, String actorName, int feePerEpisode, String type)
			throws NegativeNumException, NotExistShowException, CharacterExistException, UnknownActorTypeException {
		if (feePerEpisode < 0) {
			throw new NegativeNumException();
		} else if (!isThereSelectedShow()) {
			throw new NotExistShowException();
		} else if (VIRTUAL.equalsIgnoreCase(type)) {
			return addVirtualActor(characterName, actorName, feePerEpisode, type);
		} else if (REAL.equalsIgnoreCase(type)) {
			return addRealActor(characterName, actorName, feePerEpisode, type);
		} else {
			throw new UnknownActorTypeException();
		}
	}

	public String addfamilyRelationShip(String father, String son)
			throws NotExistShowException, SameCharacterException, NonExistentActor, RepeatedRelationShip {
		if (!isThereSelectedShow()) {
			throw new NotExistShowException();
		} else if (father.equalsIgnoreCase(son)) {
			throw new SameCharacterException();
		} else if (!currentShow.ThereThisCharacter(father)) {
			throw new NonExistentActor(father);
		} else if (!currentShow.ThereThisCharacter(son)) {
			throw new NonExistentActor(son);
		} else if (currentShow.areTheseTwoRelated(father, son)) {
			throw new RepeatedRelationShip();
		} else {
			Personagem fatherCharacter = currentShow.getThisCharacter(father);
			currentShow.getThisCharacter(son).addParents(fatherCharacter);
			Personagem sonCharacter = currentShow.getThisCharacter(son);
			fatherCharacter.addSons(sonCharacter);
			return String.format("%s has now %d kids. %s has now %d parent(s)", father,
					fatherCharacter.getSons().size(), son, sonCharacter.getParents().size());
		}
	}

	/**
	 * adds a virtual caracter to the application and to the current show
	 * 
	 * @param characterName
	 * @param actorName
	 * @param feePerEpisode
	 * @param type
	 * @throws CharacterExistException
	 */
	private String addVirtualActor(String characterName, String actorName, int feePerEpisode, String type)
			throws CharacterExistException {
		if (virtualActors.containsKey(characterName)) {
			throw new CharacterExistException();
		} else {
			Actor act = new VirtualActorClass(characterName, actorName, feePerEpisode, type);
			Personagem car = new PersonagemClass(characterName);
			currentShow.addCharacter(car); // adds to a show collection of Personagems
			virtualActors.put(characterName, act); //// adds only in virtual actors collection
			actorsCollection.add(act); // adds to the application of all kinds of actors collection
			actorsPerShow.get(currentShow.getShowName()).add(act); // adds to a map of showName, charactersCollection
			List<Quote> quotes = new ArrayList<Quote>();
			quotesPerCharacters.put(characterName, quotes);
			return String.format("%s is now part of %s. This is a virtual actor", characterName,
					currentShow.getShowName(), actorName);
		}
	}

	/**
	 * adds a real actor to the application and to the current show
	 * 
	 * @param characterName
	 * @param actorName
	 * @param feePerEpisode
	 * @param type
	 * @throws CharacterExistException
	 */
	private String addRealActor(String characterName, String actorName, int feePerEpisode, String type)
			throws CharacterExistException {
		RealActor act = null;
		if (getThisActor(actorName) == null) {
			act = new RealActorClass(characterName, actorName, feePerEpisode, type);
		} else {
			act = (RealActor) getThisActor(actorName);
		}
		act.addCharacter(characterName);
		Personagem car = new PersonagemClass(characterName);
		currentShow.addCharacter(car); // adds to a show collection of actors
		actorsCollection.add(act); // adds to the application of all kinds of actors collection
		actorsPerShow.get(currentShow.getShowName()).add(act); // adds to a map of showName, charactersCollection
		addShowToActorCollection(actorName);
		List<Quote> quotes = new ArrayList<Quote>();
		quotesPerCharacters.put(characterName, quotes);
		return String.format("%s is now part of %s. This is %s role %d", characterName, currentShow.getShowName(),
				actorName, act.numberOfParticipatedCharacters());
	}

	public String addRomanticRelationShip(String character1, String character2)
			throws NotExistShowException, SameCharacterException, NonExistentActor, RepeatedRelationShip {
		if (!isThereSelectedShow()) {
			throw new NotExistShowException();
		} else if (character1.equalsIgnoreCase(character2)) {
			throw new SameCharacterException();
		} else if (!currentShow.ThereThisCharacter(character1)) {
			throw new NonExistentActor(character1);
		} else if (!currentShow.ThereThisCharacter(character2)) {
			throw new NonExistentActor(character2);
		} else if (currentShow.areTheseTwoRomantic(character1, character2)) {
			throw new RepeatedRelationShip();
		} else {
			Personagem partner1 = currentShow.getThisCharacter(character1);
			Personagem partner2 = currentShow.getThisCharacter(character2);
			partner1.addRomanticPartner(partner2);
			partner2.addRomanticPartner(partner1);
			return String.format("%s and %s are now a couple", character1, character2);
		}
	}

	public void addEvent(String eventName, int seasonNum, int episodeNum, int nrPlayersIn, String[] playersNames)
			throws NotExistShowException, InexistentSeasonException, InexistentEpisodeNumber, NonExistentActor {

		if (!isThereSelectedShow()) {
			throw new NotExistShowException();
		} else if (seasonNum < 0 || seasonNum > currentShow.getNumberOfSeasons()) {
			throw new InexistentSeasonException();
		} else if (episodeNum > currentShow.getThisSeason(seasonNum).size()) {
			throw new InexistentEpisodeNumber();
		} else if (nrPlayersIn > 0) {
			int counter = 0;
			while (counter < nrPlayersIn) {
				String player = playersNames[counter++];
				if (!currentShow.ThereThisCharacter(player)) {
					throw new NonExistentActor(player);
				}
			}
		}
		Event event = new EventClass(eventName, seasonNum, episodeNum, currentShow.getShowName());
		int j = 0;
		while (j < nrPlayersIn) {
			String personagem = playersNames[j++];
			Personagem cc = currentShow.getThisCharacter(personagem);
			event.addCharacter(cc);
			cc.addEvent(event);
			// currentShow.addEpisodeToACharacter(personagem, seasonNum, episodeNum);
			// ///////////////////////////////////////
		}
		currentShow.addEvent(seasonNum, episodeNum, event, playersNames);
	}

	public void canIterateEvents(int seasonStart, int seasonEnd)
			throws NotExistShowException, InexistentSeasonException {
		int ola = 4;
		if (!isThereSelectedShow()) {
			throw new NotExistShowException();
<<<<<<< HEAD
		}else if(!(seasonStart>0&&seasonEnd<=currentShow.getNumberOfSeasons())) {
=======
		} else if (ola !=4) {
>>>>>>> master
			throw new InexistentSeasonException();
		}
	}

	public Iterator<Episode> getEpisodes(int season) {
		return currentShow.getEpisodes(season);
	}

	public Iterator<Personagem> getCurrentShowCharacters() throws EmptyCollectionException {
		if (!currentShow.iterateAllCharacters().hasNext()) {
			throw new EmptyCollectionException();
		}
		return currentShow.iterateAllCharacters();
	}

	public void addQuote(int season, int episode, String character, String quote)
			throws NotExistShowException, InexistentSeasonException, InexistentEpisodeNumber, NonExistentActor {
		if (!isThereSelectedShow()) {
			throw new NotExistShowException();
		} else if (season < 0 || season > currentShow.getNumberOfSeasons()) {
			throw new InexistentSeasonException();
		} else if (episode > currentShow.getThisSeason(season).size()) {
			throw new InexistentEpisodeNumber();
		} else if (!currentShow.ThereThisCharacter(character)) {
			throw new NonExistentActor();
		} else {
			Quote qq = new QuoteClass(season, episode, character, quote);
			quotesPerCharacters.get(hasThisCharacterAQuote(character)).add(qq);
		}
	}

	public Personagem characterResume(String characterName) throws NotExistShowException, NonExistentActor {
		if (!isThereSelectedShow()) {
			throw new NotExistShowException();
		} else if (!currentShow.ThereThisCharacter(characterName)) {
			throw new NonExistentActor();
		} else {
			return currentShow.getThisCharacter(characterName);
		}
	}

	/**
	 * adds a show to an actor collection of shows
	 * 
	 * @param actorName
	 */
	private void addShowToActorCollection(String actorName) {
		if (showsPerActors.containsKey(actorName)) {
			showsPerActors.get(actorName).add(currentShow);
		} else {
			LinkedList<Show> myShows = new LinkedList<>();
			showsPerActors.put(actorName, myShows);
		}
	}

	private boolean mapContainsThisKey(String showName) {
		Set<String> c = shows.keySet();
		for (String string : c) {
			if (showName.equalsIgnoreCase(string)) {
				currentShowName = string;
				return true;
			}
		}
		currentShowName = "";
		return false;
	}

	/**
	 * an override of the method contains key in map quotesPerCharacters
	 * 
	 * @param character
	 * @return
	 */
	private String hasThisCharacterAQuote(String character) {
		Iterator<String> it = quotesPerCharacters.keySet().iterator();
		while (it.hasNext()) {
			String kk = it.next();
			if (character.equalsIgnoreCase(kk)) {
				return kk;
			}
		}
		return null;
	}

	private Actor getThisActor(String actorName) {
		for (Actor actor : actorsCollection) {
			if (actorName.equalsIgnoreCase(actor.getActorName())) {
				return actor;
			}
		}
		return null;
	}
}
