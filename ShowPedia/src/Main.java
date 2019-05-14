import java.util.Scanner;


import aplication.Admin.Aplication;
import aplication.Admin.AplicationClass;
<<<<<<< HEAD
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
=======
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
>>>>>>> master
	}
	private static Commands getCommand(Scanner input) {
<<<<<<< HEAD
		return Commands.EXIT;
=======
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

>>>>>>> master
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

<<<<<<< HEAD
	private static void addShow(Scanner in, Aplication a1) throws ExistShowException {
		String showName = in.nextLine();
		try {
			a1.addShow(showName);
			System.out.printf(SHOW_ADDED,showName);
		}catch (ExistShowException except) {
			
		}
		
	}
	private static void existShowExceptionHandler() {
		
=======
	private static void criaCarrinho(Aplication a1, Scanner in) {

>>>>>>> master
	}

}
