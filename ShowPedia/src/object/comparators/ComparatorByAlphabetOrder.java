package object.comparators;

import java.util.Comparator;

import object.Show.Show;

public class ComparatorByAlphabetOrder implements Comparator<Show> {
	@Override
	public int compare(Show o1, Show o2) {
		return o1.getShowName().compareTo(o2.getShowName());
	}

}
