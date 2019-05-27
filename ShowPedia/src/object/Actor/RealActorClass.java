package object.Actor;

import java.util.Iterator;


import java.util.Map;
import java.util.TreeMap;

import character.object.Personagem;
import character.object.PersonagemClass;

public class RealActorClass extends AbstractActorClass implements RealActor {
	
	private Map<String, Personagem> characters;
	public RealActorClass(String characterName, String actorName, int feePerEpisode, String type) {
		super(actorName, feePerEpisode, type);
		characters = new TreeMap<String, Personagem>();	
		Personagem car = new PersonagemClass(characterName,actorName);
		characters.put(characterName, car);
		
	}
	
	public void addCharacter(Personagem character) {
		String name = hasThisCharacterName(character.getCharacterName());
		if(name==null) {
			characters.put(character.getCharacterName(), character);
		}else {
			characters.replace(name, character);
		}
			
	}
	public Map<String, Personagem> getCharacters(){
		return characters;
	}
	public boolean hasThisCharacter(String characterName) {
		return hasThisCharacterName(characterName)!=null;
	}
	private String hasThisCharacterName(String characterName) {
		Iterator<String> pp = characters.keySet().iterator();
		while(pp.hasNext()) {
			String name = pp.next();
			if(characterName.equalsIgnoreCase(name)) {
				return name;
			}
		}
		return null;
	}
	public int myRelationsNum() {
		int numParteners = 0;
		Iterator<Personagem> it = characters.values().iterator();
		while(it.hasNext()) {
			Personagem persona = it.next();
			numParteners +=persona.getLovers().size();
		}
		return numParteners;
	}
	public int numberOfParticipatedCharacters() {
		return getCharacters().size();
	}
	
}
