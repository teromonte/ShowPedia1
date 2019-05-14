import java.util.Scanner;

import aplication.Admin.Aplication;
import aplication.Admin.AplicationClass;

import exceptions.All.CommDontExist;
import exceptions.All.ExistShowException;
import exceptions.All.NotExistShowException;

public class Main {

	//constantes que definem as mensagens
	
	private static final String SHOW_ADDED = "%s created.\n";
<<<<<<< Updated upstream
	private static final String GOODBYE = "Bye!";
=======
	private static final String SHOW_ALREADY_EXISTS = "Show already exists!";
	private static final String GOODBYE = "Bye!";
	private static final String UNKNOWN_SHOW = "Unknown show!";
>>>>>>> Stashed changes

	public static void main(String[] args) {
		Aplication a1 = new AplicationClass();
		Scanner in = new Scanner(System.in);
		Commands option = getCommand(in);
		while (!option.equals(Commands.EXIT)) {
			executeCommand(option, a1, in);
			option = getCommand(in);
		}
		System.out.println(GOODBYE);
		in.close();
	}

	private static Commands getCommand(Scanner in) {
		String name = in.next().toUpperCase();
		in.nextLine();
		try {
			return Commands.fromString(name);
		} catch (CommDontExist e) {
			System.out.println(Commands.UNKNOWN);
			return Commands.UNKNOWN;
		}
	}
	private static void executeCommand(Commands option, Aplication a1, Scanner in) {
		switch (option) {
<<<<<<< Updated upstream
		case HELP:
			processHelp();
			break;
		case CART:
			addShow(input, a1);
=======
		case ADDSHOW:
			addShow(in, a1);
>>>>>>> Stashed changes
			break;
		default:
			break;
		}
	}
<<<<<<< Updated upstream
	
	private static void processHelp() {
		for (StaticMethods.Help d : StaticMethods.Help.values())
			StaticMethods.pegaAjuda(d);
	}

=======
>>>>>>> Stashed changes
	private static void addShow(Scanner in, Aplication a1) {
		String showName = in.nextLine();
		try {
			a1.addShow(showName);
			System.out.printf(SHOW_ADDED, showName);
		} catch (ExistShowException except) {
			System.out.println(SHOW_ALREADY_EXISTS);
		}
	}
	private static void switchToShow(Scanner in, Aplication a1) {
		String showName = in.nextLine();
		try {
			a1.switchToShow(showName);
			System.out.println(a1.);
		}catch (NotExistShowException except) {
			System.out.println(UNKNOWN_SHOW);
		}
	}
}
