package character.object;

import java.util.Iterator;
import java.util.List;

import object.Event.Event;

public interface Personagem {

	/**
	 * 
	 * @return character name
	 */
	String getCharacterName();

	/**
	 * 
	 * @param car adds a son relationship to a character
	 */
	public void addSons(Personagem car);

	/**
	 * adds a parent relationship to a character
	 * 
	 * @param parent
	 */
	public void addParents(Personagem parent);

	/**
	 * 
	 * @return map of parents
	 */
	public List<Personagem> getParents();

	/**
	 * 
	 * @return a map of sons
	 */
	public List<Personagem> getSons();

	Iterator<Personagem> iterateParents();

	public Iterator<Personagem> iterateSons();

	/**
	 * return true if "son" is my son
	 * 
	 * @param son
	 * @return
	 */
	boolean isMySon(String son);

	/**
	 * 
	 * @param father
	 * @return true if "father" is my father
	 */
	boolean isMyParent(String father);

	/**
	 * 
	 * adds event to a character
	 * @param event
	 */
	void addEvent(Event event);
}
