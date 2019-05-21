package object.Show;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import character.object.Personagem;
import exceptions.All.CharacterExistException;

import object.Episode.Episode;
import object.Episode.EpisodeClass;
import object.Event.Event;

public class ShowClass implements Show {
	
	Map<Integer, List<Episode>> episodesPerSeason; // <TEMPORADA,EPISODIOS>
	Map<String, Personagem> characters; // a collection of characters featuring the show
	List<Event> eventsList;

	private int totalEpisodeCount;
	private String name;
	private int numberOfSesons;
	private List<Episode> episodes;
	private String currentSearchName;
	
	public ShowClass(String name) {
		this.name = name;
		totalEpisodeCount = 0;

		episodesPerSeason = new HashMap<Integer, List<Episode>>(); //
		numberOfSesons = 1; // Um show já comeca com uma temporada pronta
		episodes = new LinkedList<Episode>(); // e um aray de episodios, logo de cara
		episodesPerSeason.put(numberOfSesons, episodes); //
		characters = new TreeMap<String, Personagem>();
		eventsList = new ArrayList<Event>();
		currentSearchName = "";

	}

	public String getShowName() {
		return name;
	}

	public int getNumberOfSeasons() {
		return numberOfSesons;
	}

	public int getAllEpisodesNumber() {
		return totalEpisodeCount;
	}

	public void addCharacter(Personagem act) throws CharacterExistException {
		String charName = act.getCharacterName();
		if (mapContainsThisKey(charName)!=null) {
			throw new CharacterExistException();
		} else {
			characters.put(charName, act);
		}
	}

	public void addSeason() {
		numberOfSesons++;
		List<Episode> episodes = new LinkedList<Episode>();
		episodesPerSeason.put(numberOfSesons, episodes);
	}

	public Map<Integer, List<Episode>> getEpisodesPerSeason() {
		return episodesPerSeason;
	}

	public void addEpisodeToSeason(int season, String episodeName) {
		Episode p = new EpisodeClass(episodeName);
		episodesPerSeason.get(season).add(p);
		totalEpisodeCount++;

	}
	/*Considering that the relation is transitive mutual*/
	public boolean areTheseTwoRelated(String personName1, String personName2) {
		return getThisCharacter(personName1).isMyParent(personName2) || getThisCharacter(personName1).isMySon(personName2);
	}
	public boolean areTheseTwoRomantic(String character1, String character2) {
		return getThisCharacter(character1).isMyRomanticPartner(character2);	
	}
	public boolean ThereThisCharacter(String player) {
		return getThisCharacter(player)!=null;
	}
	public Personagem getThisCharacter(String character) {
		Iterator<Personagem> it = characters.values().iterator();
		while(it.hasNext()) {
			Personagem u = it.next();
			if(u.getCharacterName().equalsIgnoreCase(character)) {
				return u;
			}
		}
		return null;
	}
	public Iterator<Personagem> iterateAllCharacters(){
		return characters.values().iterator();
	}
	public List<Episode> getThisSeason(int seasonNum){
		return episodesPerSeason.get(seasonNum);
	}
	public List<Event> getEvents(){
		return eventsList;
	}
	/**
	 * looks for a String key in the map, ignoring string's cases
	 * 
	 * @param showName
	 * @return
	 */
	private String mapContainsThisKey(String showName) {
		Set<String> c = characters.keySet();
		for (String string : c) {
			if (showName.equalsIgnoreCase(string)) {
				return string;
			}
		}
		return null;
	}
}
