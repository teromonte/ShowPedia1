package aplication.Admin;

import java.util.HashMap;
import java.util.Map;

import exceptions.All.ExistShowException;
import exceptions.All.NotExistShowException;
import object.Episode.Episode;
import object.Episode.EpisodeClass;
import object.Show.Show;
import object.Show.ShowClass;

public class AplicationClass implements Aplication {
	
	private Map<String,Show> shows;
	
	private Show currentShow;
	
	public AplicationClass() {
		shows = new HashMap<String, Show>();
		currentShow = null;
	}
	public void addShow(String showName) throws ExistShowException {
		if(shows.containsKey(showName)) {
			throw new ExistShowException();
		}else {
			Show s = new ShowClass(showName);
			shows.put(showName, s);
		}
	}
	public boolean isThereSelectedShow() {
		return currentShow!=null;
	}
	public String getCurrentShow() throws NotExistShowException{
		if(currentShow==null) {
			throw new NotExistShowException();
		}
		int numberOfEpisodes = currentShow.getAllEpisodesNumber();
		return String.format("%s. Seasons: %d Episodes: %d",currentShow.getShowName(),currentShow.getNumberOfSeasons(),numberOfEpisodes);
	}
	public void switchToShow(String showName) throws NotExistShowException {
		if(shows.containsKey(showName)) {
			currentShow = shows.get(showName);
		}else {
			throw new NotExistShowException();
		}
	}
	
	public void addSeason() throws NotExistShowException{
		if(isThereSelectedShow()) {
			currentShow.addSeason();
		}else {
			throw new NotExistShowException();
		}
	}
	public void addEpisode(int seasonNumber, String episodeName) throws NotExistShowException {
		if(!isThereSelectedShow()) {
			throw new NotExistShowException("NOSHOW");
		}else if(!currentShow.getSeasonsPerEpisode().containsKey(seasonNumber)){
			throw new NotExistShowException("NOSEASON");
		}else {
			currentShow.addEpisodeToSeason(seasonNumber, episodeName);
		}
	}
}
