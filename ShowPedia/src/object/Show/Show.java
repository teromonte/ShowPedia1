package object.Show;

import java.util.Iterator;

import java.util.List;

import java.util.Map;

import character.object.Personagem;
import exceptions.All.CharacterExistException;
import object.Episode.Episode;
import object.Event.Event;

public interface Show {

	/**
	 * 
	 * @return the show's name
	 */
	String getShowName();
	/**
	 * 
	 * @return number of seasons
	 */
	int getNumberOfSeasons();
	/**
	 * 
	 * @return a map that has number of seasons as key and a collection of episodes as value
	 */
	Map<Integer, List<Episode>> getEpisodesPerSeason();
	/**
	 * 
	 * @return total episodes count.
	 */
	int getAllEpisodesNumber();
	/**
	 * increments the number of seasons
	 */
	void addSeason();
	/**
	 * adds an episode to a season assuming there is not any episoded named "episodeName"
	 * @param season the season number
	 * @param episodeName the episode name
	 * 
	 */
	void addEpisodeToSeason(int season, String episodeName);
	/**
	 * 
	 * @param seasonNum
	 * @return the given season
	 */
	List<Episode> getThisSeason(int seasonNum);
	/**
	 * Add a new character to the show.
	 * @param act an which can be a real or a virtual one 
	 * @throws CharacterExistException
	 */
	void addCharacter(Personagem act) throws CharacterExistException;
	/**
	 * 
	 * @param character
	 * @return the character of the given name
	 */
	 Personagem getThisCharacter(String character);
	 
	 Iterator<Personagem> iterateAllCharacters();
	 /**
	  * returns true if the show has a character with the name player
	  * @param player
	  * @return
	  */
	 boolean ThereThisCharacter(String player);
	 /**
	  * 
	  * @param personName1
	  * @param personName2
	  * @pre ThereThisCharacter(personName1)&&ThereThisCharacter(personName2)
	  * @return if there is a family relationship between personName1 and personName2
	  */
	 boolean areTheseTwoRelated(String personName1, String personName2);
	 /**
	  * 
	  * @param character1
	  * @param character2
	  * @return true if character1 and character2 are in a romantic relationship
	  */
	 boolean areTheseTwoRomantic(String character1, String character2);
	 /**
	  * 
	  * @param season
	  * @param episode
	  * @param event
	  */
	 void addEvent(int season, int episode, Event event);
	 
	 void addEpisodeToACharacter(String character, int season, int episode);
	 
	 /**
	  * lists all events of a the episode of a season
	  * @param season
	  * @param episode
	  * @return  
	  */
	 Iterator<Episode> getEpisodes(int season);
}
