
public enum Commands {

	CART("CRIA CARRINHO"), ITEM("CRIA ARTIGO"), DEPOSIT("DEPOSITA"), REMOVE("REMOVE"), LIST("LISTA"), PAY("PAGA"),
	EXIT("SAIR"), UNKNOWN("UNKNOWN");

	private final String name;

	private Commands(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
