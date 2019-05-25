package character.object;

import java.util.ArrayList;


import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import object.Episode.Episode;
import object.Event.Event;
import object.Quote.Quote;
import object.Show.Show;
import object.showsComparator.ComparatorByAlphabetOrder;

public class PersonagemClass implements Personagem {
	
	
	private List<Personagem> sonsCollection;
	private List<Personagem> parentsCollection;
	private List<Personagem> romanticPartners;
	private List<Personagem> siblings;
	private List<Episode> myEpisodes;
	private List<Event> myEvents;
	private List<Quote> myQuotes;
	private String characterName;

	public PersonagemClass(String name) {
		characterName = name;
		sonsCollection = new ArrayList<>();
		parentsCollection = new ArrayList<>();
		romanticPartners = new ArrayList<>();
		myEpisodes = new ArrayList<>();
		siblings = new ArrayList<>();
		myEvents = new ArrayList<Event>();
		myQuotes = new ArrayList<>();
	}

	public String getCharacterName() {
		return characterName;
	}

	public void addSons(Personagem car) {
		sonsCollection.add(car);
	}

	public void addSibling(Personagem par) {
		Iterator<Personagem> pp = par.iterateSons();
		while (pp.hasNext()) {
			Personagem ss = pp.next();
			if (!ss.getCharacterName().equalsIgnoreCase(characterName)) {
				if (!isRelative(siblings.iterator(), ss.getCharacterName())) {
					siblings.add(ss);
				}
			}

		}
	}

	public void addParents(Personagem parent) {
		parentsCollection.add(parent);
	}

	public void addRomanticPartner(Personagem partner) {
		romanticPartners.add(partner);
	}

	public List<Personagem> getParents() {
		return parentsCollection;
	}

	public List<Personagem> getSons() {
		return sonsCollection;
	}

	public List<Personagem> getLovers() {
		return romanticPartners;
	}

	public List<Personagem> getSiblings() {
		return siblings;
	}

	public List<Quote> getMyQuotes() {
		return myQuotes;
	}
	public Quote getThisQuote(String quote) {
		Iterator<Quote> it = myQuotes.iterator();
		while(it.hasNext()) {
			Quote q = it.next();
			if(q.getQuote().equalsIgnoreCase(quote)) {
				return q;
			}
		}
		return null;
	}
	public List<Episode> getMyEpisodes() {
		return myEpisodes;
	}

	public Iterator<Personagem> iterateParents() {
		return getParents().iterator();
	}

	public Iterator<Personagem> iterateSons() {
		return getSons().iterator();
	}

	public Iterator<Personagem> iterateSiblings() {
		return siblings.iterator();
	}

	public Iterator<Personagem> iterateRomanticPartners() {
		return romanticPartners.iterator();
	}

	public Iterator<Event> iterateEvents() {
		return myEvents.iterator();
	}

	public boolean isMyRomanticPartner(String characterName) {
		return isRelative(iterateRomanticPartners(), characterName);
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
		while (tt.hasNext()) {
			Personagem p = tt.next();
			if (p.getCharacterName().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}
}
