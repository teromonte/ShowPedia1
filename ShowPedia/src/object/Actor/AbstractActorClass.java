package object.Actor;

public abstract class AbstractActorClass implements Actor {
	
	
	private String characterName;
	private String actorName;
	private String type;
	private int feePerEpisode;
	protected AbstractActorClass(String characterName, String actorName, int feePerEpisode, String type) {
		this.characterName=characterName;
		this.actorName=actorName;
		this.feePerEpisode=feePerEpisode;
		this.type=type;
	}
	public String getCharacterName() {
		return characterName;
	}
	
	public String getActorName() {
		return actorName;
	}
	
	public int getFeePerEpisode() {
		return feePerEpisode;
	}
	public String getType() {
		
	}
	

}
