import java.util.Iterator;
import java.util.Scanner;

import aplication.Admin.Aplication;
import aplication.Admin.AplicationClass;
import character.object.Personagem;
import exceptions.All.CharacterExistException;
import exceptions.All.CommDontExist;
import exceptions.All.EmptyCollectionException;
import exceptions.All.ExistShowException;
import exceptions.All.InexistentEpisodeNumber;
import exceptions.All.InexistentSeasonException;
import exceptions.All.NegativeNumException;
import exceptions.All.NonExistentActor;
import exceptions.All.NotExistShowException;
import exceptions.All.NotRelatedException;
import exceptions.All.RepeatedRelationShip;
import exceptions.All.SameCharacterException;
import exceptions.All.UnknownActorTypeException;
import object.Episode.Episode;
import object.Event.Event;

public class Main {

	// constantes que definem as mensagens

	private static final String SHOW_ADDED = "%s created.\n";
	private static final String SHOW_ALREADY_EXISTS = "Show already exists!";
	private static final String GOODBYE = "Bye!";
	private static final String NO_SHOW_SELECTED = "No show is selected!";
	private static final String UNKNOWN_SHOW = "Unknown show!";
	private static final String DUPLICATED_CHARACTER = "Duplicate character names are not allowed!";
	private static final String INVALID_TYPE = "Unknown actor category!";
	private static final String NO_SLAVERY = "Slavery is long gone and this is outrageous!";
	private static final String FATHER_SON = "%s cannot be parent and child at the same time!\n";
	private static final String NON_EXISTENT_CHARACTER = "Who is %s?\n";
	private static final String REPEATED_RELATIONSHIP = "What else is new? We already know about those two...";
	private static final String NO_SEASON = "%s does not have season %d!\n";
	private static final String NO_EPISODE = "%s S%d does not have episode %d!\n";
	private static final String SORRY_NO_SELF_DATING = "%s cannot be in a single person romantic relationship!\n";
	private static final String QUOTE_ADDED = "Quote added.";
	private static final String INVALID_SEASON_NUMB = "Invalid seasons interval!";
	private static final String DUUUUUUH = "Like... you know, they are THE SAME character! duuuuh...";
	private static final String NOT_RELATED = "These characters are not related!";

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
		in.nextLine();
		try {
			return Commands.stringToCommand(name);
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
		case ADDCHARACTER:
			addCharacter(in, a1);
			break;
		case ADDRELATIONSHIP:
			addRelationShip(in, a1);
			break;
		case ALL:
			allCharactersAndParents(a1);
			break;
		case ADDEVENT:
			addEvent(in, a1);
			break;
		case ADDROMANCE:
			addRomanticRelationShip(in, a1);
			break;
		case ADDQUOTE:
			addQuote(in, a1);
			break;
		case SEASONSOUTLINE:
			seasonsOutline(in, a1);
			break;
		case CHARACTERRESUME: characterResume(in, a1);break;
		case HOWARETHESETWORELATED: howAreTheseTwoRelated(in, a1);break;
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

	private static void addCharacter(Scanner in, Aplication a1) {
		String type = in.nextLine();
		String characterName = in.nextLine();
		String actorName = in.nextLine();
		int payGrade = 0;
		try {
			payGrade = in.nextInt();
			in.nextLine();
			System.out.println(a1.addCharacter(characterName, actorName, payGrade, type));
		} catch (NotExistShowException exception) {
			System.out.println(NO_SHOW_SELECTED);
		} catch (CharacterExistException exception) {
			System.out.println(DUPLICATED_CHARACTER);
		} catch (UnknownActorTypeException exception) {
			System.out.println(INVALID_TYPE);
		} catch (NegativeNumException exception) {
			System.out.println(NO_SLAVERY);
		}
	}

	private static void addRelationShip(Scanner in, Aplication a1) {
		String father = in.nextLine();
		String son = in.nextLine();
		try {
			System.out.println(a1.addfamilyRelationShip(father, son));
		} catch (NotExistShowException exception) {
			System.out.println(NO_SHOW_SELECTED);
		} catch (SameCharacterException exception) {
			System.out.printf(FATHER_SON, father);
		} catch (NonExistentActor exception) {
			System.out.printf(NON_EXISTENT_CHARACTER, exception.getMessage());
		} catch (RepeatedRelationShip exception) {
			System.out.println(REPEATED_RELATIONSHIP);
		}
	}

	private static void allCharactersAndParents(Aplication a1) {
		try {
			System.out.println("all");
			Iterator<Personagem> it = a1.getCurrentShowCharacters();
			while (it.hasNext()) {
				Personagem cc = it.next();
				System.out.printf("Character Name: %s| number of parents: %d| number of sons: %d \n",
						cc.getCharacterName(), cc.getParents().size(), cc.getSons().size());
			}
		} catch (EmptyCollectionException exception) {
			System.out.println("empty");
		}

	}

	private static void addEvent(Scanner in, Aplication a1) {
		String eventName = in.nextLine();
		int seasonNum = in.nextInt();
		int episodeNum = in.nextInt();
		int nrPlayersIn = in.nextInt();
		in.nextLine();
		int i = 0;
		String playersNames[] = new String[nrPlayersIn];
		while (i < nrPlayersIn) {
			String playerName = in.nextLine();
			playersNames[i++] = playerName;
		}
		try {
			a1.addEvent(eventName, seasonNum, episodeNum, nrPlayersIn, playersNames);
			System.out.println("Event added.");
		} catch (NotExistShowException exception) {
			System.out.println(NO_SHOW_SELECTED);
		} catch (InexistentSeasonException exception) {
			System.out.printf(NO_SEASON, a1.getCurrentShowObject().getShowName(), seasonNum);
		} catch (InexistentEpisodeNumber exception) {
			System.out.printf(NO_EPISODE, a1.getCurrentShowObject().getShowName(), seasonNum, episodeNum);
		} catch (NonExistentActor exception) {
			System.out.printf(NON_EXISTENT_CHARACTER, exception.getMessage());
		}
	}

	private static void addRomanticRelationShip(Scanner in, Aplication a1) {
		String character1 = in.nextLine();
		String character2 = in.nextLine();
		try {
			System.out.println(a1.addRomanticRelationShip(character1, character2));
		} catch (NotExistShowException exception) {
			System.out.println(NO_SHOW_SELECTED);
		} catch (SameCharacterException exception) {
			System.out.printf(SORRY_NO_SELF_DATING, character1);
		} catch (NonExistentActor exception) {
			System.out.printf(NON_EXISTENT_CHARACTER, exception.getMessage());
		} catch (RepeatedRelationShip exception) {
			System.out.println(REPEATED_RELATIONSHIP);
		}
	}

	private static void addQuote(Scanner in, Aplication a1) {
		int season = in.nextInt();
		int episode = in.nextInt();
		in.nextLine();
		String character = in.nextLine();
		String quote = in.nextLine();
		try {
			a1.addQuote(season, episode, character, quote);
			System.out.println(QUOTE_ADDED);
		} catch (NotExistShowException exception) {
			System.out.println(NO_SHOW_SELECTED);
		} catch (InexistentSeasonException exception) {
			System.out.printf(NO_SEASON, a1.getCurrentShowObject().getShowName(), season);
		} catch (InexistentEpisodeNumber exception) {
			System.out.printf(NO_EPISODE, a1.getCurrentShowObject().getShowName(), season, episode);
		} catch (NonExistentActor exception) {
			System.out.printf(NON_EXISTENT_CHARACTER, character);
		}
	}

	private static void seasonsOutline(Scanner in, Aplication a1) {
		int seasonStart = in.nextInt();
		int seasonEnd = in.nextInt();
		in.nextLine();
		try {
			a1.canIterateEvents(seasonStart, seasonEnd);
			while (seasonStart <= seasonEnd) {
				Iterator<Episode> episode = a1.getEpisodes(seasonStart);
				while (episode.hasNext()) {
					Episode ep = episode.next();
					System.out.printf("S%d Ep%d: %s\n", seasonStart, ep.getEpisodeNum(), ep.getEpisodeName());
					Iterator<Event> events = ep.iterateEvents();
					while (events.hasNext()) {
						Event ev = events.next();
						System.out.println(ev.getEventName());
					}
				}
				seasonStart++;
			}

		} catch (NotExistShowException exception) {
			System.out.println(NO_SHOW_SELECTED);
		} catch (InexistentSeasonException exception) {
			System.out.println(INVALID_SEASON_NUMB);
		}
	}
	private static void characterResume(Scanner in, Aplication a1) {
		String characterName = in.nextLine();
		try {
		Personagem pp=a1.characterResume(characterName);
		System.out.print("Parents: ");
		fatherNames(pp.iterateParents());
		System.out.print("Kids: ");
		fatherNames(pp.iterateSons());
		System.out.print("Siblings: ");
		fatherNames(pp.iterateSiblings());
		System.out.print("Romantic relationships: ");
		fatherNames(pp.iterateRomanticPartners());
		
		Iterator<Integer> seasons = a1.getCurrentShowObject().iterateSeasons();
		while(seasons.hasNext()) {
			int ss = seasons.next();
			System.out.println(ss+"temporadas");
		 Iterator<Episode> episodes = a1.getCurrentShowObject().getEpisodes(ss);
		 	while(episodes.hasNext()) {
		 		Episode epi = episodes.next();
		 		if(epi.ThisCharacterInThisEpsisode(characterName)) {
		 			System.out.printf("S%d Ep%d: %s\n",ss,epi.getEpisodeNum(),epi.getEpisodeName());
		 			Iterator<Event> events = epi.getThisCharacterEvents(characterName);
		 			while(events.hasNext()) {
		 				System.out.println(events.next().getEventName());
		 			}
		 		}
		 	}
		}
		
		}catch(NotExistShowException exception) {
			System.out.println(NO_SHOW_SELECTED);
		}catch (NonExistentActor exception) {
			System.out.printf(NON_EXISTENT_CHARACTER,characterName);
		}
	}
	private static void fatherNames(Iterator<Personagem> pers) {
		if(!pers.hasNext()) {
			System.out.println("None.");
		}else {
			while(pers.hasNext()) {
				System.out.print(pers.next().getCharacterName());
				if(pers.hasNext()) {
				System.out.print(", ");
				}
			}
			System.out.println();
		}
	}
	private static void howAreTheseTwoRelated(Scanner in, Aplication a1) {
		String character1 = in.nextLine();
		String character2 = in.nextLine();
		try {
			Iterator<Personagem> it = a1.howAreTheseTwoRelated(character1, character2);
			while(it.hasNext()) {
				//Personagem pp = it.next();
				System.out.print(it.next().getCharacterName());
				if(it.hasNext()) {
					System.out.print("; ");
				}
			}
			System.out.println();
		}catch (NotExistShowException exception) {
			System.out.println(NO_SHOW_SELECTED);
		}catch (NonExistentActor exception) {
			System.out.printf(NON_EXISTENT_CHARACTER,exception.getMessage());
		}catch (SameCharacterException exception) {
			System.out.println(DUUUUUUH);
		}catch (NotRelatedException exception) {
			System.out.println(NOT_RELATED);
		}
	}
}
