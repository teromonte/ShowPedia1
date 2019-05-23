package object.Actor;

import java.util.Map;
import java.util.TreeMap;

import character.object.Personagem;
import character.object.PersonagemClass;

public class RealActorClass extends AbstractActorClass implements RealActor {
	private Map<String, Personagem> characters;
	
	public RealActorClass(String characterName, String actorName, int feePerEpisode, String type) {
		super(actorName, feePerEpisode, type);
		characters = new TreeMap<String, Personagem>();	
		Personagem car = new PersonagemClass(characterName);
		characters.put(characterName, car);
		
	}
	
	public void addCharacter(String character) {
		Personagem car = new PersonagemClass(character);
		characters.put(character, car);
	}
	public Map<String, Personagem> getCharacters(){
		return characters;
	}
	@Override
	public int compareTo(Actor o) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int numberOfParticipatedCharacters() {
		return getCharacters().size();
	}
}
