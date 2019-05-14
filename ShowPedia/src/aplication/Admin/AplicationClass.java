package aplication.Admin;

import java.util.HashMap;
import java.util.Map;

import exceptions.All.ExistShowException;
import exceptions.All.NotExistShowException;
import object.Show.Show;
import object.Show.ShowClass;

public class AplicationClass implements Aplication {
	
	private Map<String,Show>showList;
	private Show currentShow;
	public AplicationClass() {
		showList = new HashMap<String, Show>();
		currentShow = null;
	}
	public void addShow(String showName) throws ExistShowException {
		if(showList.containsKey(showName)) {
			throw new ExistShowException();
		}else {
			Show s = new ShowClass(showName);
			showList.put(showName, s);
		}
	}
	public String getCurrentShow() {
		int numberOfEpisodes = currentShow.getSeasonsPerEpisode().size();
		return String.format("%s. Seasons: %d Episodes: %d",currentShow.getShowName(),currentShow.getNumberOfSeasons(),numberOfEpisodes);
	}
	public void switchToShow(String showName) throws NotExistShowException {
		if(showList.containsKey(showName)) {
			currentShow = showList.get(showName);
		}else {
			throw new NotExistShowException();
		}
	}
}
