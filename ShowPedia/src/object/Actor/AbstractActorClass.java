package object.Actor;

import java.util.Iterator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import object.Show.Show;
import object.comparators.ComparatorByAlphabetOrder;

public abstract class AbstractActorClass implements Actor {

	private SortedSet<Show> myShows;
	private Map<String, Integer> participatedShowsWithRelation;
	private String actorName;
	private String type;
	private int feePerEpisode;

	protected AbstractActorClass(String actorName, int feePerEpisode, String type) {
		myShows = new TreeSet<>(new ComparatorByAlphabetOrder());
		participatedShowsWithRelation = new TreeMap<String, Integer>();
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
