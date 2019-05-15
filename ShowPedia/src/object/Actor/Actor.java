package object.Actor;

public interface Actor {

	/**
	 * 
	 * @return the character name
	 */
	String getCharacterName();
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
}
