package object.Show;

import java.util.List;
import java.util.Map;

import exceptions.All.CharacterExistException;
import object.Actor.Actor;
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
	Map<Integer, List<Episode>> getSeasonsPerEpisode();
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
	void addCharacter(Actor act) throws CharacterExistException;
}
