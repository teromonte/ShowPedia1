package object.Actor;

import java.util.Iterator;


import java.util.Map;
import java.util.TreeMap;

import character.object.Personagem;
import character.object.PersonagemClass;

public class RealActorClass extends AbstractActorClass implements RealActor {
	
	
	public RealActorClass(String characterName, String actorName, int feePerEpisode, String type) {
		super(actorName, feePerEpisode, type);
		Personagem p = new PersonagemClass(characterName, actorName);
		addCharacter(p);
		
	}
	
	
	
	
}
