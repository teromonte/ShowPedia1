import java.util.Scanner;

import aplication.Admin.Aplication;
import aplication.Admin.AplicationClass;
import exceptions.All.CommDontExist;
import exceptions.All.ExistShowException;
import exceptions.All.NotExistShowException;

public class Main {

	// constantes que definem as mensagens

	private static final String SHOW_ADDED = "%s created.\n";
	private static final String SHOW_ALREADY_EXISTS = "Show already exists!";
	private static final String GOODBYE = "Bye!";
	private static final String NO_SHOW_SELECTED = "No show is selected!";
	private static final String UNKNOWN_SHOW = "Unknown show!";

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
		System.out.print("> ");
		String name = in.next().toUpperCase();
		if (!Commands.isCommValid(name)) {
			name = in.nextLine().toUpperCase();
		}
		try {
			return Commands.fromString(name);
		} catch (CommDontExist e) {
			System.out.println("Unknown command. Type help to see available commands.");
			return Commands.UNKNOWN;
		}
	}

	private static void executeCommand(Commands option, Aplication a1, Scanner in) {
		switch (option) {
		case HELP:
			processHelp();
			break;
		case ADDSHOW:
			addShow(in, a1);
			break;
		case CURRENTSHOW:
			currentShow(a1);
			break;
		case SWITCHTOSHOW:
			switchToShow(in, a1);
			break;
		case ADDSEASON:
			addSeason(a1);
			break;
		case ADDEPISODE:
			addEpisodeToSeason(in, a1);
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
		String showName = in.nextLine().trim();
		try {
			a1.addShow(showName);
			System.out.printf(SHOW_ADDED, showName);
		} catch (ExistShowException except) {
			System.out.println(SHOW_ALREADY_EXISTS);
		}
	}

	private static void currentShow(Aplication a1) {
		try {
			System.out.println(a1.getCurrentShow());
		} catch (NotExistShowException except) {
			System.out.println(NO_SHOW_SELECTED);
		}
	}

	private static void switchToShow(Scanner in, Aplication a1) {
		String showName = in.nextLine().trim();
		try {
			a1.switchToShow(showName);
			currentShow(a1);
		} catch (NotExistShowException except) {
			System.out.println(UNKNOWN_SHOW);
		}
	}

	private static void addSeason(Aplication a1) {
		try {
			a1.addSeason();
			currentShow(a1);
		} catch (NotExistShowException except) {
			System.out.println(NO_SHOW_SELECTED);
		}

	}

	private static void addEpisodeToSeason(Scanner in, Aplication a1) {
		int seasonNumber = in.nextInt();
		String episodeName = in.nextLine().trim();
		try {
			System.out.println(a1.addEpisode(seasonNumber, episodeName));

		} catch (NotExistShowException except) {
			StaticMethods.handleNotExistShowException(except);
		}
	}

}
