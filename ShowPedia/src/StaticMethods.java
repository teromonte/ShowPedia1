import exceptions.All.NotExistShowException;

public class StaticMethods {

	public static final String BASE_INFO = "currentShow - show the current show";
	public static final String LISTBASES_INFO = "addShow - add a new show";
	public static final String DRONE_INFO = "switchToShow - change the context to a particular show";
	public static final String SERVICE_INFO = "addSeason - add a new season to the current show";
	public static final String SWARM_INFO = "addEpisode - add a new episode to a particular season of the current show";
	public static final String SWARMCOMPONENTS_INFO = "addCharacter - add a new character to a show";
	public static final String DISBAND_INFO = "addRelationship - add a family relationship between characters";
	public static final String LISTDRONES_INFO = "addRomance - add a romantic relationship between characters";
	public static final String FLYTOBASE_INFO = "addEvent - add a significant event involving at least one character";
	public static final String ADDORDER_INFO = "addQuote - add a new quote to a character";
	public static final String ORDERS_INFO = "seasonsOutline - outline the contents of the selected seasons for the selected show";
	public static final String ALLORDERS_INFO = "characterResume - outline the main information on a specific character";
	public static final String DELIVER_INFO = "howAreTheseTwoRelated - find out if and how two characters may be related";
	public static final String DELIVERED_INFO = "famousQuotes - find out which character(s) said a particular quote";
	public static final String INTRANSIT_INFO = "alsoAppearsOn - which other shows and roles is the same actor on?";
	public static final String TICTAC_INFO = "mostRomantic - find out who is at least as romantic as X";
	public static final String ASDLH = "kingOfCGI - find out which company has earned more revenue with their CGI virtual actors";
	public static final String HELP_INFO = "help - shows the available commands";
	public static final String EXIT_INFO = "exit - terminates the execution of the program";
	private static final String NO_SHOW_SELECTED = "No show is selected!";
	private static final String UNKNOWN_SEASON = "Unknown season!";

	public static final String UNKNOWN = "Unknown command. Type help to see available commands.";
	public static final String BYE = "Bye!";

	public StaticMethods() {

	}

	public enum Help {
		BASE_INFO, LISTBASES_INFO, DRONE_INFO, SERVICE_INFO, SWARM_INFO, SWARMCOMPONENTS_INFO, DISBAND_INFO,
		LISTDRONES_INFO, FLYTOBASE_INFO, ADDORDER_INFO, ORDERS_INFO, ALLORDERS_INFO, DELIVER_INFO, DELIVERED_INFO,
		INTRANSIT_INFO, TICTAC_INFO, ASDLH, HELP_INFO, EXIT_INFO;
	}
	
	public static void handleNotExistShowException(NotExistShowException except) {
		switch (except.getMessage()) {
		case "NOSHOW":
			System.out.println(NO_SHOW_SELECTED);
			break;
		case "NOSEASON":
			System.out.println(UNKNOWN_SEASON);
			break;
		}
	}

	public static void pegaAjuda(Help info) {
		switch (info) {
		case BASE_INFO:
			System.out.println(BASE_INFO);
			break;
		case LISTBASES_INFO:
			System.out.println(LISTBASES_INFO);
			break;
		case DRONE_INFO:
			System.out.println(DRONE_INFO);
			break;
		case SERVICE_INFO:
			System.out.println(SERVICE_INFO);
			break;
		case SWARM_INFO:
			System.out.println(SWARM_INFO);
			break;
		case SWARMCOMPONENTS_INFO:
			System.out.println(SWARMCOMPONENTS_INFO);
			break;
		case DISBAND_INFO:
			System.out.println(DISBAND_INFO);
			break;
		case LISTDRONES_INFO:
			System.out.println(LISTDRONES_INFO);
			break;
		case FLYTOBASE_INFO:
			System.out.println(FLYTOBASE_INFO);
			break;
		case ADDORDER_INFO:
			System.out.println(ADDORDER_INFO);
			break;
		case ORDERS_INFO:
			System.out.println(ORDERS_INFO);
			break;
		case ALLORDERS_INFO:
			System.out.println(ALLORDERS_INFO);
			break;
		case DELIVER_INFO:
			System.out.println(DELIVER_INFO);
			break;
		case DELIVERED_INFO:
			System.out.println(DELIVERED_INFO);
			break;
		case INTRANSIT_INFO:
			System.out.println(INTRANSIT_INFO);
			break;
		case TICTAC_INFO:
			System.out.println(TICTAC_INFO);
			break;
		case ASDLH:
			System.out.println(ASDLH);
			break;
		case HELP_INFO:
			System.out.println(HELP_INFO);
			break;
		case EXIT_INFO:
			System.out.println(EXIT_INFO);
			break;
		}
	}

}
