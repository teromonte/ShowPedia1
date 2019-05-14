package object.Show;

import java.util.List;
import java.util.Map;

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
}
