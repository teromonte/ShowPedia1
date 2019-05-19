package object.Actor;

public class RealActorClass extends AbstractActorClass implements RealActor {

	public RealActorClass(String characterName, String actorName, int feePerEpisode, String type) {
		super(characterName, actorName, feePerEpisode, type);
	}

	@Override
	public int compareTo(Actor o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
