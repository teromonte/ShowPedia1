import exceptions.All.CommDontExist;

public enum Commands {

	//depois remover o comando "ALL"
	ADDSHOW("ADDSHOW"), HELP("HELP"), CURRENTSHOW("CURRENTSHOW"), SWITCHTOSHOW("SWITCHTOSHOW"), ADDSEASON("ADDSEASON"),
	ADDEPISODE("ADDEPISODE"), ADDCHARACTER("ADDCHARACTER"), ADDRELATIONSHIP("ADDRELATIONSHIP"), ALL("ALL"), ADDEVENT("ADDEVENT"),
	ADDROMANCE("ADDROMANCE"),
	EXIT("EXIT"), UNKNOWN("Unknown command. Type help to see available commands.");

	private final String name;

	private Commands(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static boolean isCommValid(String command) {
		if (command.equals("ADDSHOW") || command.equals("HELP") || command.equals("CURRENTSHOW")
				|| command.equals("SWITCHTOSHOW") || command.equals("ADDSEASON") || command.equals("ADDEPISODE")
				|| command.equals("EXIT") || command.equals("ADDCHARACTER") || command.equals("ALL")||
				command.equals("ADDRELATIONSHIP") ||command.equals("ADDEVENT") || command.equals("ADDROMANCE")                   ) {
			return true;
		} else {
			return false;
		}
	}

	public static Commands fromString(String command) throws CommDontExist {
		for (Commands c : Commands.values()) {
			if (c.getName().equalsIgnoreCase(command)) {
				return c;
			}
		}
		CommDontExist exception;
		exception = new CommDontExist();
		throw exception;
	}

}
