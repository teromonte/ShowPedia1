import java.util.Scanner;

import aplication.Admin.Aplication;
import aplication.Admin.AplicationClass;

public class Main {
	
	private static final String GOODBYE = "Volte sempre.\n";

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Commands comm = getCommand(in);
		Aplication a1 = new AplicationClass();
		
		while (!comm.equals(Commands.EXIT)) {
			executeCommand(comm, a1, in);
			comm = getCommand(in);
			System.out.println();
		}

		System.out.println(GOODBYE);
		in.close();

	}

	private static Commands getCommand(Scanner input) {
		return Commands.EXIT;

	}

	private static void executeCommand(Commands option, Aplication a1, Scanner input) {
		switch (option) {
		case CART:
			CriaCarrinho(a1, input);
			break;
		default:
			break;
		}
	}

	private static void CriaCarrinho(Aplication a1, Scanner in) {

	}

}
