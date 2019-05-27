package object.comparators;

import java.util.Comparator;

import object.Actor.Actor;

public class ComparatorByRomanticPartners implements Comparator<Actor> {

	@Override
	public int compare(Actor o1, Actor o2) {
		int a2Relations = o2.myRelationsNum();
		int a2Shows = o2.numberOfParticipatedShows();
		int a2ShowsWithRelation = o2.numberOfParticipatedShowsWithRelation(); 
		if(o1.myRelationsNum()>a2Relations) {
			return -1;
		}else if(o1.myRelationsNum()<a2Relations) {
			return +1;
		}else if(o1.numberOfParticipatedShows()<a2Shows) {
			return -1;
		}else if(o1.numberOfParticipatedShows()>a2Shows) {
			return +1;
		}else if(o1.numberOfParticipatedShowsWithRelation()>a2ShowsWithRelation) {
			return -1;
		}else if(o1.numberOfParticipatedShowsWithRelation()<a2ShowsWithRelation) {
			return +1;
		}else {
			return o1.getActorName().compareTo(o2.getActorName());
		}

	}

}
