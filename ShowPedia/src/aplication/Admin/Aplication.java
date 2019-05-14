package aplication.Admin;

import exceptions.All.ExistShowException;

public interface Aplication {
	
	/**
	 * adds a show by giving its name
	 * @param showName
	 * @throws ExistShowException if there is a already a show the same name
	 */
	void addShow(String showName) throws ExistShowException;

}
