package character.object;

import java.util.Iterator;
import java.util.List;

import exceptions.All.RepeatedRelationShip;
import object.Episode.Episode;
import object.Event.Event;
import object.Quote.Quote;

public interface Personagem {

	/**
	 * 
	 * @return character name
	 */
	String getCharacterName();

	/**
	 * 
	 * @param car adds a son relationship to a character
	 */
	public void addSons(Personagem car);

	/**
	 * adds a parent relationship to a character
	 * 
	 * @param parent
	 */
	public void addParents(Personagem parent);
	/**
	 * adds a romantic partner
	 * @param partner
	 */
	void addRomanticPartner(Personagem partner);
	/**
	 * 
	 * @return map of parents
	 */
	public List<Personagem> getParents();

	/**
	 * 
	 * @return a map of sons
	 */
	public List<Personagem> getSons();
	/**
	 * 
	 * @return
	 */
	List<Personagem> getLovers();
	/**
	 * 
	 * @return an array of siblings
	 */
	List<Personagem> getSiblings();

	 List<Episode> getMyEpisodes();
	
	Iterator<Personagem> iterateParents();

	public Iterator<Personagem> iterateSons();

	/**
	 * return true if "son" is my son
	 * 
	 * @param son
	 * @return
	 */
	boolean isMySon(String son);

	/**
	 * 
	 * @param father
	 * @return true if "father" is my father
	 */
	boolean isMyParent(String father);
	/**
	 * 
	 * @param characterName
	 * @return true if characterName is is in a romantic relationship with this character
	 */
	boolean isMyRomanticPartner(String characterName);

	/**
	 * 
	 * adds event to a character
	 * @param event
	 */
	void addEvent(Event event);
	/**
	 * 
	 * @return this character quotes collection
	 */
	List<Quote> getMyQuotes();
	/**
	 * 
	 * @return
	 */
	Iterator<Personagem> iterateSiblings();
	
	Iterator<Personagem> iterateRomanticPartners();
	
	Iterator<Event>iterateEvents();
	
	
}
