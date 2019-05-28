import exceptions.All.CommDontExist;

public enum Commands {

	ADDSHOW("ADDSHOW"), HELP("HELP"), CURRENTSHOW("CURRENTSHOW"), SWITCHTOSHOW("SWITCHTOSHOW"), ADDSEASON("ADDSEASON"),
	ADDEPISODE("ADDEPISODE"), ADDCHARACTER("ADDCHARACTER"), ADDRELATIONSHIP("ADDRELATIONSHIP"), ALL("ALL"), ADDEVENT("ADDEVENT"),
	ADDROMANCE("ADDROMANCE"), ADDQUOTE("ADDQUOTE"), SEASONSOUTLINE("SEASONSOUTLINE"), CHARACTERRESUME("CHARACTERRESUME"),
	HOWARETHESETWORELATED("HOWARETHESETWORELATED"),FAMOUSQUOTES("FAMOUSQUOTES"), ALSOAPPEARSON("ALSOAPPEARSON"),MOSTROMANTIC("MOSTROMANTIC"),
	KINGOFCGI("KINGOFCGI"),EMPRESAS("EMP"),
	EXIT("EXIT"), ALLACTORS("ACTORS"), UNKNOWN("Unknown command. Type help to see available commands.");

	private final String name;

	private Commands(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static Commands stringToCommand(String command) throws CommDontExist {
		for (Commands c : Commands.values()) {
			if (c.getName().equals(command)) {
				return c;
			}
		}
		CommDontExist exception;
		exception = new CommDontExist();
		throw exception;
	}

}
