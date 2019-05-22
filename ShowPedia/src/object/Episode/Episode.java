package object.Episode;

import java.util.Iterator;
import java.util.List;

import object.Event.Event;

public interface Episode {

	List<Event> getEvents();

	void addEvent(Event event);

	Iterator<Event> iterateEvents();
	
	int getEpisodeNum();
	
	String getEpisodeName();
}
