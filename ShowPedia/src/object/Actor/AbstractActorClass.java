package object.Actor;

import java.util.Iterator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import character.object.Personagem;
import character.object.PersonagemClass;
import object.Show.Show;
import object.comparators.ComparatorByAlphabetOrder;

public abstract class AbstractActorClass implements Actor {

	private SortedSet<Show> myShows;
	private Map<String, Integer> participatedShowsWithRelation;
	private Map<String, Personagem> characters;
	private String actorName;
	private String type;
	private int feePerEpisode;

	protected AbstractActorClass(String actorName, int feePerEpisode, String type) {
		myShows = new TreeSet<>(new ComparatorByAlphabetOrder());
		participatedShowsWithRelation = new TreeMap<String, Integer>();
		characters = new TreeMap<>();
		this.actorName = actorName;
		this.feePerEpisode = feePerEpisode;
		this.type = type;
	}

	public String getActorName() {
		return actorName;
	}
	public void upDateNumberOfShowsWithRelation(String showName) {
		if(!participatedShowsWithRelation.containsKey(showName)) {
			participatedShowsWithRelation.put(showName, 1);
		}
	}
	public int getFeePerEpisode() {
		return feePerEpisode;
	}

	public String getType() {
		return type;
	}

	public void addShow(Show e) {
		boolean found = false;
		Iterator<Show> it = myShows.iterator();
		while (it.hasNext() && !found) {
			Show s = it.next();
			if (s.getShowName().equalsIgnoreCase(e.getShowName())) {
				found = true;
				myShows.remove(s);
				myShows.add(e);
			}
		}
		if (!found) {
			myShows.add(e);
		}
	}

	public void addCharacter(Personagem character) {
		String name = hasThisCharacterName(character.getCharacterName());
		if(name==null) {
			characters.put(character.getCharacterName(), character);
		}else {
			characters.replace(name, character);
		}
			
	}
	public Map<String, Personagem> getCharacters(){
		return characters;
	}
	
	private String hasThisCharacterName(String characterName) {
		Iterator<String> pp = characters.keySet().iterator();
		while(pp.hasNext()) {
			String name = pp.next();
			if(characterName.equalsIgnoreCase(name)) {
				return name;
			}
		}
		return null;
	}
	public boolean hasThisCharacter(String characterName) {
		return hasThisCharacterName(characterName)!=null;
	}
	
	public int myRelationsNum() {
		int numParteners = 0;
		Iterator<Personagem> it = characters.values().iterator();
		while(it.hasNext()) {
			Personagem persona = it.next();
			numParteners +=persona.getLovers().size();
		}
		return numParteners;
	}
	public int numberOfParticipatedCharacters() {
		return getCharacters().size();
	}
	public Iterator<Show> getAllShows() {
		return myShows.iterator();
	}
	public int numberOfParticipatedShowsWithRelation() {
		return participatedShowsWithRelation.size();
	}
	public int numberOfParticipatedShows() {
		return myShows.size();
	}
	@Override
	public boolean equals(Object o) {
		if(o!=null) {
			Actor a = (Actor) o;
			return this.actorName.equalsIgnoreCase(a.getActorName());
			
		}else {
			return false;
		}
	}
}
