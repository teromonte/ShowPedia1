package object.Show;

import java.util.Iterator;

import java.util.List;

import java.util.Map;

import character.object.Character;
import exceptions.All.CharacterExistException;
import object.Episode.Episode;

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
	 * Add a new character to the show.
	 * @param act an which can be a real or a virtual one 
	 * @throws CharacterExistException
	 */
	void addCharacter(Character act) throws CharacterExistException;
	/**
	 * 
	 * @param character
	 * @return the character of the given name
	 */
	 Character getThisCharacter(String character);
	 
	 Iterator<Character> iterateAllCharacters();
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
}
