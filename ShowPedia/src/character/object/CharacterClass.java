package character.object;

import java.util.Map;
import java.util.TreeMap;

public class CharacterClass implements Character {

	private Map<String, Character> sonsCollection;
	private Map<String, Character> parentsCollection;
	private String actorName;
	public CharacterClass(String name) {
		actorName = name;
		sonsCollection = new TreeMap<>();
		parentsCollection = new TreeMap<>();
	}
	
	public String getCharacterName() {
		return actorName;
	}
	public void addSons(Character car) {
		sonsCollection.put(car.getCharacterName(),car);
	}
	public void addParents(Character parent) {
		parentsCollection.put(parent.getCharacterName(),parent);
	}
	public Map<String, Character> getParents(){
		return parentsCollection;
	}
	public Map<String, Character> getSons(){
		return sonsCollection;
	}
}
