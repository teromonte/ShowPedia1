package object.Actor;

import java.util.Iterator;
import java.util.Map;

import character.object.Personagem;
import object.Show.Show;

public interface Actor {

	//there are some methods here that consider the possibily of cgi characters having relationships
	// in a near future, since the problem description text does not mention anything about it
	
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
	
	Map<String, Personagem> getCharacters();
}
