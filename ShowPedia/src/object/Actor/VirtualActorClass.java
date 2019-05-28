package object.Actor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import character.object.Personagem;
import character.object.PersonagemClass;

public class VirtualActorClass extends AbstractActorClass implements VirtualActor {

	private Map<String, Integer> characterWithPayment;
	private Map<String, List<Integer>> characterWithSeasons;

	public VirtualActorClass(String characterName, String companyName, int feePerSeason, String type) {
		super(companyName, feePerSeason, type);
		Personagem virtual = new PersonagemClass(characterName, companyName);
		addCharacter(virtual);
		characterWithPayment = new TreeMap<>();
		characterWithSeasons = new TreeMap<>();
		characterWithPayment.put(characterName, feePerSeason);
		insertCharacterNameWithNumSeasons(characterName, 0);
	}

	public void insertCharacterNameWithPayment(String name, int payment) {
		if (!characterWithPayment.containsKey(name)) {
			characterWithPayment.put(name, payment);
		}
	}

	public void insertCharacterNameWithNumSeasons(String name, int season) {
		if (characterWithSeasons.containsKey(name)) {
			if (!characterWithSeasons.get(name).contains(season)) {
				if(season!=0) {
					characterWithSeasons.get(name).add(season);
				}
			}
		} else {
			List<Integer> list = new ArrayList<>();
			if(season!=0) {
				list.add(season);
			}
			characterWithSeasons.put(name, list);
		}
	}

	private int getAllMoney() {
		int result = 0;
		Iterator<String> list = characterWithSeasons.keySet().iterator();
		while (list.hasNext()) {
			String name = list.next();
			result += characterWithSeasons.get(name).size() * characterWithPayment.get(name);
		}
		return result;
	}

	public int totalRevenue() {
		return getAllMoney();
	}
}
