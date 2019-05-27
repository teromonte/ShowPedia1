package object.Actor;

import character.object.Personagem;
import character.object.PersonagemClass;

public class VirtualActorClass extends AbstractActorClass implements VirtualActor {

	private Personagem virtual;

	public VirtualActorClass(String characterName, String companyName, int feePerSeason, String type) {
		super(companyName, feePerSeason, type);
		virtual = new PersonagemClass(characterName, companyName);
	}

	public Personagem getCharacter() {
		return virtual;
	}
	public void addCharacter(Personagem character) {
		virtual = character;
	}
	public boolean hasThisCharacter(String characterName) {
		return virtual.getCharacterName().equalsIgnoreCase(characterName);
	}
	public int myRelationsNum() {
		return virtual.getLovers().size();
	}
	
	
	
}
