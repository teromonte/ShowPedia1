package character.object;
import java.util.Iterator;
import java.util.List;

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
	public List<Character> getParents();
	/**
	 * 
	 * @return a map of sons
	 */
	public List<Character> getSons();
	
	Iterator<Character> iterateParents();
	
	public Iterator<Character> iterateSons();
	
	/**
	  * return true if "son" is my son
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
}
