package object.Actor;

import character.object.Character;
import character.object.CharacterClass;

public class VirtualActorClass extends AbstractActorClass implements VirtualActor {
	
	
	
	private Character virtual;
	public VirtualActorClass(String characterName, String companyName, int feePerSeason, String type) {
		super(companyName, feePerSeason, type);
		virtual = new CharacterClass(characterName);
	}

	public Character getCharacter() {
		return virtual;
	}
	@Override
	public int compareTo(Actor o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
