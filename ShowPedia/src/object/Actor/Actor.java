package object.Actor;

import java.util.Iterator;

import object.Show.Show;

public interface Actor extends Comparable<Actor> {

	/**
	 * 
	 * @return the actor name
	 */
	public String getActorName();

	/**
	 * 
	 * @return feePerEpisode if it is a real actor, else fee per season
	 */
	public int getFeePerEpisode();

	String getType();

	void addShow(Show e);

	Iterator<Show> getAllShows();
	
	boolean hasThisCharacter(String characterName);
}
