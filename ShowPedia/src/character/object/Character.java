package character.object;

import java.util.Map;

public interface Character {

	/**
	 * 
	 * @return character name
	 */
	String getCharacterName();
	/**
	 * 
	 * @param car adds a son relationship to a character
	 */
	public void addSons(Character car);
	/**
	 * adds a parent relationship to a character
	 * @param parent
	 */
	public void addParents(Character parent);
	/**
	 * 
	 * @return map of parents
	 */
	public Map<String, Character> getParents();
	/**
	 * 
	 * @return a map of sons
	 */
	public Map<String, Character> getSons();
}
