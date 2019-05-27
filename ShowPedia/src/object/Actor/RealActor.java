package object.Actor;

import java.util.Map;

import character.object.Personagem;

public interface RealActor extends Actor {
	/**
	 * @return the number of roles this actor has
	 */
	int numberOfParticipatedCharacters();
	 /**
	  * add character to a user
	  * @param character
	  */
	 void addCharacter(Personagem character);
	 
	 Map<String, Personagem> getCharacters();
}
