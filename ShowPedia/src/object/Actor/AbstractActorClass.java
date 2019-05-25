package object.Actor;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

import object.Show.Show;
import object.showsComparator.ComparatorByAlphabetOrder;

public abstract class AbstractActorClass implements Actor {

	private SortedSet<Show> myShows;
	private String actorName;
	private String type;
	private int feePerEpisode;

	protected AbstractActorClass(String actorName, int feePerEpisode, String type) {
		myShows = new TreeSet<>(new ComparatorByAlphabetOrder());
		this.actorName = actorName;
		this.feePerEpisode = feePerEpisode;
		this.type = type;

	}

	public String getActorName() {
		return actorName;
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
			}
		}
		if (!found) {
			myShows.add(e);
		}
	}

	public Iterator<Show> getAllShows() {
		return myShows.iterator();
	}
}
