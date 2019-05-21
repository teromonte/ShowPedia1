package character.object;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

import exceptions.All.RepeatedRelationShip;
import object.Event.Event;
import object.Quote.Quote;

public class PersonagemClass implements Personagem {

	private List<Personagem> sonsCollection;
	private List<Personagem> parentsCollection;
	private List<Personagem> romanticPartners;
	private List<Event> myEvents;
	private List<Quote> myQuotes;
	private String actorName;

	public PersonagemClass(String name) {
		actorName = name;
		sonsCollection = new ArrayList<>();
		parentsCollection = new ArrayList<>();
		romanticPartners = new ArrayList<>();
		myEvents = new ArrayList<Event>();
		myQuotes = new ArrayList<>();
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
	public void addRomanticPartner(Personagem partner){
		romanticPartners.add(partner);
	}
	public List<Personagem> getParents() {
		return parentsCollection;
	}

	public List<Personagem> getSons() {
		return sonsCollection;
	}
	
	public List<Personagem> getLovers(){
		return romanticPartners;
	}
	
	public List<Quote> getMyQuotes(){
		return myQuotes;
	}
	public Iterator<Personagem> iterateParents() {
		return getParents().iterator();
	}

	public Iterator<Personagem> iterateSons() {
		return getSons().iterator();
	}

	public Iterator<Personagem> iterateRomanticPartners(){
		return romanticPartners.iterator();
	}
	public boolean isMyRomanticPartner(String characterName) {
		return isRelative(iterateRomanticPartners(),characterName);
	}
	public boolean isMySon(String son) {
		return isRelative(iterateSons(), son);
	}
	public void addEvent(Event event) {
		myEvents.add(event);
	}
	public boolean isMyParent(String father) {
		return isRelative(iterateParents(), father);
	}
	private boolean isRelative(Iterator<Personagem> it, String name) {
		Iterator<Personagem> tt = it;
		while(tt.hasNext()) {
			Personagem p = tt.next();
			if(p.getCharacterName().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}
}
