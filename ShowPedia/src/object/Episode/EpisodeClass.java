package object.Episode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import object.Event.Event;

public class EpisodeClass implements Episode {
	private List<Event> eventsList;
	private List<Episode>myEpisodes;
	private String name;
	private int episodeNum; 
	private int season;
	public EpisodeClass(String name, int episodeNum, int season) {
		eventsList = new ArrayList<Event>();
		this.name = name;
		this.episodeNum=episodeNum;
		this.season = season;
		myEpisodes = new ArrayList<>();
	}
	
	public List<Event> getEvents(){
		return eventsList;
	}
	public void addEvent(Event event) {
		getEvents().add(event);
	}
	public Iterator<Event> iterateEvents(){
		return eventsList.iterator();
	}
	public int getEpisodeNum() {
		return episodeNum;
	}
	public String getEpisodeName() {
		return name;
	}
	public List<Episode> getMyEpisodes(){
		return myEpisodes;
	}
	
	
}
