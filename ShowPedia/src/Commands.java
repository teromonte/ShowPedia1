import exceptions.All.CommDontExist;

public enum Commands {

<<<<<<< Updated upstream
	CART("CRIA CARRINHO"), HELP("HELP"),ITEM("CRIA ARTIGO"), DEPOSIT("DEPOSITA"), REMOVE("REMOVE"), LIST("LISTA"), PAY("PAGA"),
=======
	ADDSHOW("ADDSHOW"), ITEM("CRIA ARTIGO"), DEPOSIT("DEPOSITA"), REMOVE("REMOVE"), LIST("LISTA"), PAY("PAGA"),
>>>>>>> Stashed changes
	EXIT("EXIT"), UNKNOWN("UNKNOWN");

	private final String name;

	private Commands(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
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
