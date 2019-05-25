package object.Actor;

import character.object.Personagem;
import character.object.PersonagemClass;

public class VirtualActorClass extends AbstractActorClass implements VirtualActor {

	private Personagem virtual;

	public VirtualActorClass(String characterName, String companyName, int feePerSeason, String type) {
		super(companyName, feePerSeason, type);
		virtual = new PersonagemClass(characterName);
	}

	public Personagem getCharacter() {
		return virtual;
	}

	public boolean hasThisCharacter(String characterName) {
		return virtual.getCharacterName().equalsIgnoreCase(characterName);
	}

	@Override
	public int compareTo(Actor o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
