package aplication.Admin;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import exceptions.All.CharacterExistException;
import exceptions.All.ExistShowException;
import exceptions.All.NegativeNumException;
import exceptions.All.NotExistShowException;
import exceptions.All.UnknownActorTypeException;
import object.Actor.Actor;
import object.Actor.RealActorClass;
import object.Actor.VirtualActorClass;
import object.Show.Show;
import object.Show.ShowClass;

public class AplicationClass implements Aplication {
	
	private static final String REAL = "REAL";
	private static final String VIRTUAL = "VIRTUAL";
	private Map<String,Show> shows;
	private Map<String, LinkedList<Actor>> actorsPerShow; // a show has a collection of actors making the show
	private Map<String, LinkedList<Show>> showsPerActors; // an has a collection of shows in which he has participated
	private SortedSet<Actor> actorsCollection; // the application registry of all the actors
	private Map<String, Actor>virtualActors; //only virtual actors
	private Show currentShow;
	private String currentShowName;

	public AplicationClass() {
		shows = new HashMap<String, Show>();
		actorsCollection = new TreeSet<Actor>();
		actorsPerShow = new TreeMap<String, LinkedList<Actor>>();
		virtualActors = new TreeMap<>();
		showsPerActors = new TreeMap<>();
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
			return String.format("%s S%d, Ep%d: %s.", currentShow.getShowName(),
					seasonNumber, currentShow.getEpisodesPerSeason().get(seasonNumber).size() , episodeName);
		}
		
	}
	public String addCharacter(String characterName, String actorName, int feePerEpisode, String type) throws NegativeNumException ,CharacterExistException, NotExistShowException, UnknownActorTypeException{
		if(feePerEpisode<0) {
			throw new NegativeNumException();
		}
		if(isThereSelectedShow()) {
			throw new NotExistShowException();
		}else if(VIRTUAL.equalsIgnoreCase(type)) {
			return addVirtualActor(characterName, actorName, feePerEpisode, type);
		}else if(REAL.equalsIgnoreCase(type)) {
			return addRealActor(characterName, actorName, feePerEpisode, type);
		}else {
			throw new UnknownActorTypeException();
		}
	}
	/**
	 * adds a virtual caracter to the application and to the current show
	 * @param characterName
	 * @param actorName
	 * @param feePerEpisode
	 * @param type
	 * @throws CharacterExistException
	 */
	private String addVirtualActor(String characterName, String actorName, int feePerEpisode, String type) throws CharacterExistException{
		if(virtualActors.containsKey(characterName)) {
			throw new CharacterExistException();
		}else {
			Actor act = new VirtualActorClass(characterName, actorName, feePerEpisode, type);
			currentShow.addCharacter(act); //adds to a show collection of actors
			virtualActors.put(characterName,act); ////adds only in virtual actors collection
			actorsCollection.add(act); // adds to the application of all kinds of actors collection
			actorsPerShow.get(currentShow.getShowName()).add(act); //adds to a map of showName, charactersCollection
		return String.format("%s is now part of %s. This is a virtual actor", characterName, currentShow.getShowName(), actorName);	
		}
	}
	/**
	 * adds a real actor to the application and to the current show
	 * @param characterName
	 * @param actorName
	 * @param feePerEpisode
	 * @param type
	 * @throws CharacterExistException
	 */
	private String addRealActor(String characterName, String actorName, int feePerEpisode, String type) throws CharacterExistException {
		Actor act = new RealActorClass(characterName, actorName, feePerEpisode, type);
		currentShow.addCharacter(act); //adds to a show collection of actors
		actorsCollection.add(act); // adds to the application of all kinds of actors collection
		actorsPerShow.get(currentShow.getShowName()).add(act); //adds to a map of showName, charactersCollection
		addShowToActorCollection(actorName);
		return String.format("%s is now part of %s. This is %s role %d", characterName, currentShow.getShowName(), actorName, showsPerActors.size());
	}
	/**
	 * adds a show to an actor collection of shows
	 * @param actorName
	 */
	private void addShowToActorCollection(String actorName) {
		if(showsPerActors.containsKey(actorName)) {
			showsPerActors.get(actorName).add(currentShow);
		}else {
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
		return false;
	}
}
