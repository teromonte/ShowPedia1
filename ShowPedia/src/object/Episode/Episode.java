package object.Episode;

import java.util.Iterator;
import java.util.List;

import object.Event.Event;

public interface Episode {

	List<Event> getEvents();

	void addEvent(Event event, String [] playersNames);

	Iterator<Event> iterateEvents();
	
	int getEpisodeNum();
	
	String getEpisodeName();
	/**
	 * 
	 * @param characterName
	 * @return true if a character is in this episode
	 */
	boolean ThisCharacterInThisEpsisode(String characterName);
	/**
	 * an iterate with events of a character
	 * @param characterName
	 * @return
	 */
	Iterator<Event> getThisCharacterEvents(String characterName);
}
