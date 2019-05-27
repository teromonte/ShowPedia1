package object.comparators;

import java.util.Comparator;

import object.Actor.VirtualActor;

public class ComparatorCgiByRevenue implements Comparator<VirtualActor>{

	@Override
	public int compare(VirtualActor o1, VirtualActor o2) {
		if(o1.totalRevenue()>o2.totalRevenue()) {
			return 1;
		}else if(o1.totalRevenue()<o2.totalRevenue()) {
			return -1;
		}else if(o1.getCharacters().size()<o2.getCharacters().size()) {
			return 1;
		}else if(o1.getCharacters().size()>o2.getCharacters().size()) {
			return -1;
		}else {
			return o1.getActorName().compareTo(o2.getActorName());
		}
	}

}
