package aplication.Admin;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import exceptions.All.ExistShowException;
import exceptions.All.NotExistShowException;
import object.Actor.RealActorClass;
import object.Episode.EpisodeClass;
import object.Episode.Episode;
import object.Show.Show;
import object.Show.ShowClass;

public class AplicationClass implements Aplication {
	private static final String REAL = "REAL";
	private static final String VIRTUAL = "VIRTUAL";
	private Map<String,Show> shows;

	private Map<String, Show> shows;

	private Show currentShow;
	private String currentShowName;

	public AplicationClass() {
		shows = new HashMap<String, Show>();
		currentShow = null;
		currentShowName = null;
	}

	public void addShow(String showName) throws ExistShowException {
		if (shows.containsKey(showName)) {
			throw new ExistShowException();
		} else {
			Show s = new ShowClass(showName);
			shows.put(showName, s);
		}
	}

	public boolean isThereSelectedShow() {
		return currentShow != null;
	}

	public String getCurrentShow() throws NotExistShowException {
		if (currentShow == null) {
			throw new NotExistShowException();
		}
		int numberOfEpisodes = currentShow.getAllEpisodesNumber();
		return String.format("%s. Seasons: %d Episodes: %d", currentShow.getShowName(),
				currentShow.getNumberOfSeasons(), numberOfEpisodes);
	}

	public void switchToShow(String showName) throws NotExistShowException {
		if (mapContainsThisKey(showName)) {
			currentShow = shows.get(currentShowName);
		} else {
			throw new NotExistShowException();
		}
	}

	public void addSeason() throws NotExistShowException {
		if (isThereSelectedShow()) {
			currentShow.addSeason();
		} else {
			throw new NotExistShowException();
		}
	}

	public void addEpisode(int seasonNumber, String episodeName) throws NotExistShowException {
		if (!isThereSelectedShow()) {
			throw new NotExistShowException("NOSHOW");
		} else if (!currentShow.getSeasonsPerEpisode().containsKey(seasonNumber)) {
			throw new NotExistShowException("NOSEASON");
		} else {
			currentShow.addEpisodeToSeason(seasonNumber, episodeName);
		}
	}
	private boolean mapContainsThisKey(String showName) {
		Set<String> c = shows.keySet();
		for (String string : c) {
			if (showName.equalsIgnoreCase(string)) {
				currentShowName = string;
				return true;
			}
		}
		return false;
	}
}
