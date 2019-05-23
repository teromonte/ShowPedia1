package aplication.Admin;

import java.util.Iterator;

import character.object.Personagem;
import exceptions.All.CharacterExistException;
import exceptions.All.EmptyCollectionException;
import exceptions.All.ExistShowException;
import exceptions.All.InexistentEpisodeNumber;
import exceptions.All.InexistentSeasonException;
import exceptions.All.NegativeNumException;
import exceptions.All.NonExistentActor;
import exceptions.All.NotExistShowException;
import exceptions.All.RepeatedRelationShip;
import exceptions.All.SameCharacterException;
import exceptions.All.UnknownActorTypeException;
import object.Episode.Episode;
import object.Show.Show;

public interface Aplication {

	/**
	 * adds a show by giving its name
	 * 
	 * @param showName
	 * @throws ExistShowException if there is a already a show the same name
	 */
	void addShow(String showName) throws ExistShowException;

	/**
	 * Changes the context to a particular show.
	 * 
	 * @param showName the show name.
	 * @throws NotExistShowException if there is no show with the given showName
	 */
	void switchToShow(String showName) throws NotExistShowException;

	/**
	 * Show which is the current show. throws NotExistShowException if there is not
	 * any selected show
	 * 
	 * @return a string with the show name, followed by the number of available
	 *         seasons and total episodes count.
	 */
	String getCurrentShow() throws NotExistShowException;

	/**
	 * adds a season to the currentShow throws NotExistShowException If there is no
	 * selected show
	 */
	void addSeason() throws NotExistShowException;

	/**
	 * Add a new episode to a particular season of the show.
	 * 
	 * @param seasonNumber - the season
	 * @param episodeName  - the episode name
	 * @throws NotExistShowException If there is no selected show or If the
	 *                               referenced season does not exist
	 */
	String addEpisode(int seasonNumber, String episodeName) throws NotExistShowException;

	/**
	 * Add a new character to the show. Add a new character to the show.
	 * 
	 * @param characterName
	 * @param actorName
	 * @param feePerEpisode
	 * @param type
	 * @throws CharacterExistException
	 * @throws NotExistShowException
	 * @throws UnknownActorTypeException
	 */
	String addCharacter(String characterName, String actorName, int feePerEpisode, String type)
			throws NegativeNumException, CharacterExistException, NotExistShowException, UnknownActorTypeException;

	/**
	 * Add a new family relationship between characters. the rst element is the
	 * parent, the second one is the child.
	 * 
	 * @param father
	 * @param son
	 * @throws NotExistShowException, If there is no selected show,
	 * @throws SameCharacterException It is not possible to establish a relationship with the same character
	 * @throws NonExistentActor If at least one of the characters does not exist
	 */
	String addfamilyRelationShip(String father, String son)
			throws NotExistShowException, SameCharacterException, NonExistentActor,RepeatedRelationShip;
	/**
	 * Add a romantic relationship between characters.
	 * In a romantic relationship, we add
	 * two elements, establishing a relationship among them.
	 * @param character1
	 * @param character2
	 * @throws NotExistShowException If there is no selected show;
	 * @throws SameCharacterException It is not possible to establish a relationship with the same character;
	 * @throws NonExistentActor If at least one of the characters does not exist;
	 * @throws RepeatedRelationShip If the relationship is repeated.
	 */
	String addRomanticRelationShip(String character1, String character2) throws NotExistShowException, SameCharacterException, 
	NonExistentActor,RepeatedRelationShip;

	Iterator<Personagem> getCurrentShowCharacters() throws EmptyCollectionException;
	/**
	 * Add a signicant event involving at least one character.The command receives
	 * the following parameters
	 * @param eventName
	 * @param seasonNum
	 * @param episodeNum
	 * @param nrPlayersIn
	 * @param playersNames
	 * @throws NotExistShowException
	 * @throws InexistentSeasonException
	 * @throws NonExistentActor
	 */
	void addEvent(String eventName, int seasonNum, int episodeNum, int nrPlayersIn, String [] playersNames) 
			throws NotExistShowException, InexistentSeasonException, InexistentEpisodeNumber, NonExistentActor ;
	/**
	 * Add a new quote to a character.
	 * The command receives the information the following information and adds that quote to tha character
	 * @param season
	 * @param episode
	 * @param character
	 * @param quote
	 * @throws NotExistShowException
	 * @throws InexistentSeasonException
	 * @throws InexistentEpisodeNumber
	 * @throws NonExistentActor
	 */
	void addQuote(int season, int episode, String character, String quote) throws NotExistShowException, 
	InexistentSeasonException, InexistentEpisodeNumber, NonExistentActor;
	
	Show getCurrentShowObject();
	/**checks the error that might interrupt the command seasonoutline
	 * 
	 * @param seasonStart
	 * @param seasonEnd
	 * @throws NotExistShowException
	 * @throws InexistentSeasonException
	 */
	void canIterateEvents (int seasonStart, int seasonEnd)throws NotExistShowException, InexistentSeasonException;
	 /**
	  *
	  * @param season
	  * @return an iterator of episodes of a season
	  */
	public Iterator<Episode> getEpisodes(int season);
	/**
	 * 
	 * @param characterName
	 * @return the character object of the given name
	 * @throws NotExistShowException If there is no selected show,
	 * @throws NonExistentActor If the character does not exist,
	 */
	Personagem characterResume(String characterName) throws NotExistShowException, NonExistentActor;
}
