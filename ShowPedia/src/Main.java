import java.util.Scanner;

import aplication.Admin.Aplication;
import aplication.Admin.AplicationClass;
import exceptions.All.ExistShowException;

public class Main {
	
	//
	private static final String SHOW_ADDED = "%s created.\n";
	private static final String GOODBYE = "Volte sempre.\n";

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Aplication a1 = new AplicationClass();
		
		

	}

	private static void interpreter(Scanner in, Aplication a1) {
		Commands comm = getCommand(in);
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

	private static void addShow(Scanner in, Aplication a1) throws ExistShowException {
		String showName = in.nextLine();
		try {
			a1.addShow(showName);
			System.out.printf(SHOW_ADDED,showName);
		}catch (ExistShowException except) {
			
		}
		
	}
	private static void existShowExceptionHandler() {
		
	}

}
