package object.Actor;

public abstract class AbstractActorClass implements Actor {
	
	
	
	private String actorName;
	private String type;
	private int feePerEpisode;
	protected AbstractActorClass(String actorName, int feePerEpisode, String type) {
		this.actorName=actorName;
		this.feePerEpisode=feePerEpisode;
		this.type=type;	
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
}
