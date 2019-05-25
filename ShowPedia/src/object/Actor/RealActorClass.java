package object.Actor;

import java.util.Iterator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;

import character.object.Personagem;
import character.object.PersonagemClass;
import object.Show.Show;

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
	public boolean hasThisCharacter(String characterName) {
		Iterator<String> pp = characters.keySet().iterator();
		while(pp.hasNext()) {
			if(characterName.equalsIgnoreCase(pp.next())) {
				return true;
			}
		}
		return false;
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
