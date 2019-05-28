package object.Actor;

public interface VirtualActor extends Actor {

	int totalRevenue();
		
	void insertCharacterNameWithPayment(String name, int payment);
	
	void insertCharacterNameWithNumSeasons(String name, int season);
	
}
