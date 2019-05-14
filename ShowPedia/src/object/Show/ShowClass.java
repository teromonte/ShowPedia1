package object.Show;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import object.Actor.Actor;
import object.Episode.Episode;

public class ShowClass implements Show {

	Map<Integer, List<Episode>> seasonsPerEpisode; // <TEMPORADA,EPISODIOS>
	SortedSet<Actor> actors;
	Map<String, List<Episode>> episodePerActor;
	private int numberSeasons;
	private String name;

	public ShowClass(String name) {
		seasonsPerEpisode = new HashMap<Integer, List<Episode>>();
		actors = new TreeSet<Actor>();
		episodePerActor = new HashMap<String,List<Episode>>();
		this.name = name;
		numberSeasons =1;
		seasonsPerEpisode.put(numberSeasons, null);
	}
	
	public String getShowName() {
		return name;
	}
	public int getNumberOfSeasons() {
		return numberSeasons;
	}
	public Map<Integer, List<Episode>> getSeasonsPerEpisode(){
		return seasonsPerEpisode;
	}

}
