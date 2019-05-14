package exceptions.All;

public class NotExistShowException extends Exception{

	public NotExistShowException() {
		super();
	}
	public NotExistShowException(String msg) {
		super(msg);
	}
	public String getMsg() {
		return super.getMessage();
	}
}
