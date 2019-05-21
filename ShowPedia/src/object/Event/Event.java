package object.Event;

import character.object.Personagem;

public interface Event {

	/**
	 * adds character "chara" to the event
	 * @param chara
	 */
	void addCharacter(Personagem chara);
	/**
	 * return the event name
	 * @return
	 */
	public String getEventName();
	/**
	 * 
	 * @return number of character the event has
	 */
	public int numberOfParticipants();
	/**
	 * 
	 * @return season
	 */
	int getSeasonNum();
	/**
	 * 
	 * @return episode
	 */
	int getEpisodeNum();
	/**
	 * 
	 * @return show name of the particular event
	 */
	String getShowName();
}
