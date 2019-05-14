import java.util.Scanner;

import aplication.Admin.Aplication;
import aplication.Admin.AplicationClass;

import exceptions.All.CommDontExist;
import exceptions.All.ExistShowException;

public class Main {

	private static final String SHOW_ADDED = "%s created.\n";
	private static final String GOODBYE = "Bye!";

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
		String name = input.next().toUpperCase();
		try {
			return Commands.fromString(name);

		} catch (CommDontExist e) {
			System.out.println(Commands.UNKNOWN);
			return Commands.UNKNOWN;
		}
	}

	private static void executeCommand(Commands option, Aplication a1, Scanner input) {
		switch (option) {
		case HELP:
			processHelp();
			break;
		case CART:
			addShow(input, a1);
			break;
		default:
			break;
		}
	}
	
	private static void processHelp() {
		for (StaticMethods.Help d : StaticMethods.Help.values())
			StaticMethods.pegaAjuda(d);
	}

	private static void addShow(Scanner in, Aplication a1) {
		String showName = in.nextLine();
		try {
			a1.addShow(showName);
			System.out.printf(SHOW_ADDED, showName);
		} catch (ExistShowException except) {

		}

	}

	private static void existShowExceptionHandler() {

	}

}
