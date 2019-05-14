import exceptions.All.CommDontExist;

public enum Commands {

	CART("CRIA CARRINHO"), HELP("HELP"),ITEM("CRIA ARTIGO"), DEPOSIT("DEPOSITA"), REMOVE("REMOVE"), LIST("LISTA"), PAY("PAGA"),
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
