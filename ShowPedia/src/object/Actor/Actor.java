package object.Actor;

import java.util.Iterator;

import character.object.Personagem;
import object.Show.Show;

public interface Actor {

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

	public int myRelationsNum();

	void addCharacter(Personagem character);

	int numberOfParticipatedShowsWithRelation();
	
	void upDateNumberOfShowsWithRelation(String showName);
	
	int numberOfParticipatedShows();
}
