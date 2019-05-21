package character.object;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

import object.Event.Event;

public class PersonagemClass implements Personagem {

	private List<Personagem> sonsCollection;
	private List<Personagem> parentsCollection;
	private List<Event> myEvents;
	private String actorName;

	public PersonagemClass(String name) {
		actorName = name;
		sonsCollection = new ArrayList<>();
		parentsCollection = new ArrayList<>();
		myEvents = new ArrayList<Event>();
	}

	public String getCharacterName() {
		return actorName;
	}

	public void addSons(Personagem car) {
		sonsCollection.add(car);
	}

	public void addParents(Personagem parent) {
		parentsCollection.add(parent);
	}

	public List<Personagem> getParents() {
		return parentsCollection;
	}

	public List<Personagem> getSons() {
		return sonsCollection;
	}

	public Iterator<Personagem> iterateParents() {
		return getParents().iterator();
	}

	public Iterator<Personagem> iterateSons() {
		return getSons().iterator();
	}

	public boolean isMySon(String son) {
		Iterator<Personagem> it = iterateSons();
		while (it.hasNext()) {
			Personagem c = it.next();
			if (son.equalsIgnoreCase(c.getCharacterName())) {
				return true;
			}
		}
		return false;
	}
	public void addEvent(Event event) {
		myEvents.add(event);
	}
	public boolean isMyParent(String father) {
		Iterator<Personagem> it = iterateParents();
		while (it.hasNext()) {
			Personagem c = it.next();
			if (father.equalsIgnoreCase(c.getCharacterName())) {
				return true;
			}
		}
		return false;
	}
}
