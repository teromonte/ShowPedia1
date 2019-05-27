package object.Actor;

import java.util.Map;
import java.util.TreeMap;

import character.object.Personagem;
import character.object.PersonagemClass;

public class VirtualActorClass extends AbstractActorClass implements VirtualActor {

	private Map<String, Integer> participatedEpisodes; 

	public VirtualActorClass(String characterName, String companyName, int feePerSeason, String type) {
		super(companyName, feePerSeason, type);
		Personagem virtual = new PersonagemClass(characterName, companyName);
		addCharacter(virtual);
		participatedEpisodes = new TreeMap<String, Integer>();
	}

	public void updateNumperOfParticipatedEpisodes(String episode, int number) {
		String gg = "Ep" + number;
		if (!participatedEpisodes.containsValue(number)) {
			participatedEpisodes.put(gg, number);
		}
	}

	public int totalRevenue() {
		return getFeePerEpisode() * participatedEpisodes.size();
	}
}
