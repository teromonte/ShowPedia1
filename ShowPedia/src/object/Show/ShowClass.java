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

	private int totalEpisodeCount;
	private String name;
	private int numberOfSesons;
	private List<Episode> episodes;
	
	public ShowClass(String name) {
		this.name = name;
		totalEpisodeCount = 0;

		episodesPerSeason = new TreeMap<Integer,List<Episode>>(); //
		numberOfSesons = 1; // Um show ja comeca com uma temporada pronta
		episodes = new ArrayList<Episode>(); // e um aray de episodios, logo de cara
		episodesPerSeason.put(numberOfSesons, episodes); //
		characters = new TreeMap<String, Personagem>();

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
		totalEpisodeCount++;
		Episode p = new EpisodeClass(episodeName,episodesPerSeason.get(season).size() + 1, season);
		episodesPerSeason.get(season).add(p);
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
	public void addEvent(int season, int episode, Event event, String [] playersNames) {
	 List<Episode> p=	episodesPerSeason.get(season);
	 Episode e = p.get(episode-1);
	 e.addEvent(event, playersNames);
	}
//	public void addEpisodeToACharacter(String character, int season, int episode) {
//		List<Episode> p=episodesPerSeason.get(season);
//		 Episode e = p.get(episode-1);
//		getThisCharacter(character).getMyEpisodes().add(e);
//	}
	public Iterator<Episode> getEpisodes(int season){
		return episodesPerSeason.get(season).iterator();
	}
	public Iterator<Integer> iterateSeasons(){
		return episodesPerSeason.keySet().iterator();
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
