package object.Event;

import java.util.ArrayList;
import java.util.List;

import character.object.Personagem;

public class EventClass implements Event {

	private List<Personagem> characters;
	private String eventName;
	private String showName;
	private int seasonNum;
	private int episodeNum;

	public EventClass(String eventName, int seasonNum, int episodeNum, String showName) {
		characters = new ArrayList<>();
		this.eventName = eventName;
		this.seasonNum = seasonNum;
		this.episodeNum = episodeNum;
		this.showName = showName;
	}

	public String getEventName() {
		return eventName;
	}

	public int getSeasonNum() {
		return seasonNum;
	}

	public int getEpisodeNum() {
		return episodeNum;
	}

	public String getShowName() {
		return showName;
	}

	public int numberOfParticipants() {
		return characters.size();
	}

	@Override
	public void addCharacter(Personagem chara) {
		characters.add(chara);
	}
}
