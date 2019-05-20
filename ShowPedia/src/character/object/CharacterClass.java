package character.object;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

public class CharacterClass implements Character {

	private List<Character> sonsCollection;
	private List<Character> parentsCollection;
	private String actorName;

	public CharacterClass(String name) {
		actorName = name;
		sonsCollection = new ArrayList<>();
		parentsCollection = new ArrayList<>();
	}

	public String getCharacterName() {
		return actorName;
	}

	public void addSons(Character car) {
		sonsCollection.add(car);
	}

	public void addParents(Character parent) {
		parentsCollection.add(parent);
	}

	public List<Character> getParents() {
		return parentsCollection;
	}

	public List<Character> getSons() {
		return sonsCollection;
	}

	public Iterator<Character> iterateParents() {
		return getParents().iterator();
	}
	public Iterator<Character> iterateSons(){
		return getSons().iterator();
	}
	public boolean isMySon(String son) {
		Iterator<Character> it = iterateSons();
		while(it.hasNext()) {
			Character c = it.next();
			if(son.equalsIgnoreCase(c.getCharacterName())) {
				return true;
			}
		}
		return false;
	}
	public boolean isMyParent(String father) {
		Iterator<Character> it = iterateParents();
		while(it.hasNext()) {
			Character c = it.next();
			if(father.equalsIgnoreCase(c.getCharacterName())) {
				return true;
			}
		}
		return false;
	}
}
