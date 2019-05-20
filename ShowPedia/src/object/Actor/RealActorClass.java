package object.Actor;

import java.util.Map;
import java.util.TreeMap;

import character.object.Character;
import character.object.CharacterClass;

public class RealActorClass extends AbstractActorClass implements RealActor {
	private Map<String, Character> characters;
	
	public RealActorClass(String characterName, String actorName, int feePerEpisode, String type) {
		super(actorName, feePerEpisode, type);
		characters = new TreeMap<String, Character>();	
		Character car = new CharacterClass(characterName);
		characters.put(characterName, car);
	}
	
	public void addCharacter(String character) {
		Character car = new CharacterClass(character);
		characters.put(character, car);
	}
	public Map<String, Character> getCharacters(){
		return characters;
	}
	@Override
	public int compareTo(Actor o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
