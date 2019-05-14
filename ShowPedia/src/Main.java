import java.util.Scanner;


import aplication.Admin.Aplication;
import aplication.Admin.AplicationClass;
import exceptions.All.CommDontExist;

public class Main {

	private static final String GOODBYE = "Volte sempre.\n";

	public static void main(String[] args) {
		Aplication a1 = new AplicationClass();
		Scanner input = new Scanner(System.in);
		Commands option = getCommand(input);
		while (!option.equals(Commands.EXIT)) {
			executeCommand(option, a1, input);
			option = getCommand(input);
			System.out.println();
		}
		System.out.println(GOODBYE);
		input.close();
	}

	private static Commands getCommand(Scanner input) {
		String nameTwo = "";
		String name = input.next().toUpperCase();
		if (name.equals("CRIA")) {
			nameTwo = input.next().toUpperCase().trim();
		}

		try {
			if (!name.equals("CRIA"))
				return Commands.fromString(name);
			else
				return Commands.fromString(name + " " + nameTwo);
		} catch (CommDontExist e) {
			System.out.println(Commands.UNKNOWN);
			return Commands.UNKNOWN;
		}

	}

	private static void executeCommand(Commands option, Aplication supermarket, Scanner input) {
		switch (option) {
		case CART:
			criaCarrinho(supermarket, input);
			break;
		default:
			break;
		}
	}

	private static void criaCarrinho(Aplication a1, Scanner in) {

	}

}
