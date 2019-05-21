package object.Actor;

public interface RealActor extends Actor {
	/**
	 * @return the number of roles this actor has
	 */
	int numberOfParticipatedCharacters();
	 /**
	  * add character to a user
	  * @param character
	  */
	 void addCharacter(String character);
}
