package object.Show;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import object.Actor.Actor;
import object.Episode.Episode;
import object.Episode.EpisodeClass;

public class ShowClass implements Show {

	Map<Integer, List<Episode>> episodesPerSeason; // <TEMPORADA,EPISODIOS>
	SortedSet<Actor> actors;
	Map<String, List<Episode>> episodePerActor;
	private int numberSeasons;
	private int totalEpisodeCount;
	private String name;

	public ShowClass(String name) {
		episodesPerSeason = new HashMap<Integer, List<Episode>>();
		actors = new TreeSet<Actor>();
		episodePerActor = new HashMap<String, List<Episode>>();
		this.name = name;
		numberSeasons = 1;
		totalEpisodeCount = 0;
		episodesPerSeason.put(numberSeasons, null);
	}

	public String getShowName() {
		return name;
	}

	public int getNumberOfSeasons() {
		return numberSeasons;
	}

	public int getAllEpisodesNumber() {
		return totalEpisodeCount;
	}
	
	public void addSeason() {
		numberSeasons++;
	}

	public Map<Integer, List<Episode>> getSeasonsPerEpisode() {
		return episodesPerSeason;
	}
	public void addEpisodeToSeason(int season, String episodeName) {
		Episode p= new EpisodeClass(episodeName);
		List<Episode> list = episodesPerSeason.get(season);
		if(list==null) {
			list = new ArrayList<Episode>();
		}
		list.add(p);	
		episodesPerSeason.put(season, list);
		totalEpisodeCount++;
	}
}
