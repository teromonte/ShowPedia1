package aplication.Admin;

import exceptions.All.ExistShowException;
import exceptions.All.NotExistShowException;

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
	 * @return a string with the show name, followed by the number of available seasons and total episodes count.
	 */
	String getCurrentShow();
}
