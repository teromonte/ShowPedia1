package object.Episode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import object.Event.Event;

public class EpisodeClass implements Episode {
	private Map<String, List<Event>> eventsPerCharacter;
	private List<Event> eventsList;
	private List<Episode>myEpisodes;
	private String name;
	private int episodeNum; 
	private int season;
	public EpisodeClass(String name, int episodeNum, int season) {
		eventsList = new ArrayList<Event>();
		eventsPerCharacter = new TreeMap<String, List<Event>>();
		this.name = name;
		this.episodeNum=episodeNum;
		this.season = season;
		myEpisodes = new ArrayList<>();
	}
	
	public int getSeasonNum() {
		return season;
	}
	
	public List<Event> getEvents(){
		return eventsList;
	}
	public void addEvent(Event event, String [] playersNames) {
		int i = 0;
		while(i<playersNames.length) {
			String name = getThisCharacterName(playersNames[i]);
			if(name==null) {
				List<Event> ents = new ArrayList<>();
				eventsPerCharacter.put(playersNames[i], ents);
			}else {
				eventsPerCharacter.get(name).add(event);
			}
			i++;
		}
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
	public Iterator<Event> getThisCharacterEvents(String characterName){
		return eventsPerCharacter.get(getThisCharacterName(characterName)).iterator();
	}
	public boolean ThisCharacterInThisEpsisode(String characterName) {
		return getThisCharacterName(characterName)!=null;
	}
	private String getThisCharacterName(String characterName) {
		Iterator<String> it =  eventsPerCharacter.keySet().iterator();
		while(it.hasNext()) {
			String name = it.next();
			if(name.equalsIgnoreCase(characterName)) {
				return name;
			}
		}
		return null;
	}

	
}
