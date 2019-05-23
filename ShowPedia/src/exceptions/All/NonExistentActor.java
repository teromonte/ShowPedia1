package exceptions.All;

public class NonExistentActor extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NonExistentActor() {
		super();
	}
	public NonExistentActor (String msg) {
		super(msg);
	}
}
