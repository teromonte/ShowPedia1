package object.Show;


import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import character.object.Character;
import exceptions.All.CharacterExistException;

import object.Episode.Episode;
import object.Episode.EpisodeClass;

public class ShowClass implements Show {

	Map<Integer, List<Episode>> episodesPerSeason; // <TEMPORADA,EPISODIOS>
	Map<String, Character> characters; // a collection of characters featuring the show

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
		currentSearchName = "";
		characters = new TreeMap<String, Character>();

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

	public void addCharacter(Character act) throws CharacterExistException {
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
	public boolean ThereThisCharacter(String player) {
		return getThisCharacter(player)!=null;
	}
	public Character getThisCharacter(String character) {
		Iterator<Character> it = characters.values().iterator();
		while(it.hasNext()) {
			Character u = it.next();
			if(u.getCharacterName().equalsIgnoreCase(character)) {
				return u;
			}
		}
		return null;
	}
	public Iterator<Character> iterateAllCharacters(){
		return characters.values().iterator();
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
