package object.Show;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import character.object.Character;
import exceptions.All.CharacterExistException;
import object.Actor.Actor;
import object.Episode.Episode;
import object.Episode.EpisodeClass;

public class ShowClass implements Show {

	Map<Integer, List<Episode>> episodesPerSeason; // <TEMPORADA,EPISODIOS>

	Map<String, Character> characters;

	private int totalEpisodeCount;
	private String name;
	private int numberOfSesons;
	private String currentSearchName;
	private List<Episode> episodes;

	public ShowClass(String name) {
		this.name = name;
		totalEpisodeCount = 0;

		episodesPerSeason = new HashMap<Integer, List<Episode>>(); //
		numberOfSesons = 1; // Um show já comeca com uma temporada pronta
		episodes = new LinkedList<Episode>(); // e um aray de episodios, logo de cara
		episodesPerSeason.put(numberOfSesons, episodes); //

		characters = new HashMap<String, Character>();
		currentSearchName = null;

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
		if (mapContainsThisKey(charName)) {
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

	/**
	 * looks for a String key in the map, ignoring string's cases
	 * 
	 * @param showName
	 * @return
	 */
	private boolean mapContainsThisKey(String showName) {
		Set<String> c = characters.keySet();
		for (String string : c) {
			if (showName.equalsIgnoreCase(string)) {
				currentSearchName = string;
				return true;
			}
		}
		return false;
	}
	public Character getThisCharacter(String character) {
		return characters.get(character);
	}
}
