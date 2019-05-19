package aplication.Admin;

import exceptions.All.CharacterExistException;
import exceptions.All.ExistShowException;
import exceptions.All.NegativeNumException;
import exceptions.All.NotExistShowException;
import exceptions.All.UnknownActorTypeException;

public interface Aplication {

	/**
	 * adds a show by giving its name
	 * 
	 * @param showName
	 * @throws ExistShowException if there is a already a show the same name
	 */
	void addShow(String showName) throws ExistShowException;

	/**
	 * Changes the context to a particular show.
	 * @param showName the show name.
	 * @throws NotExistShowException if there is no show with the given showName
	 */
	void switchToShow(String showName) throws NotExistShowException;
	/**
	 * Show which is the current show.
	 * throws NotExistShowException if there is not any selected show
	 * @return a string with the show name, followed by the number of available seasons and total episodes count.
	 */
	String getCurrentShow() throws NotExistShowException;
	/**
	 * adds a season to the currentShow
	 * throws NotExistShowException If there is no selected show
	 */
	void addSeason()throws NotExistShowException;
	/**
	 * Add a new episode to a particular season of the show.
	 * @param seasonNumber - the season 
	 * @param episodeName - the episode name
	 * @throws NotExistShowException If there is no selected show or If the referenced season does not exist
	 */
	String addEpisode(int seasonNumber, String episodeName) throws NotExistShowException;
	/**
	 * Add a new character to the show. Add a new character to the show.
	 * @param characterName
	 * @param actorName
	 * @param feePerEpisode
	 * @param type
	 * @throws CharacterExistException
	 * @throws NotExistShowException
	 * @throws UnknownActorTypeException
	 */
	String addCharacter(String characterName, String actorName, int feePerEpisode, String type) throws NegativeNumException,CharacterExistException, NotExistShowException, UnknownActorTypeException;
}
