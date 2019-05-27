package object.Show;


import java.util.ArrayList;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import character.object.Personagem;
import exceptions.All.CharacterExistException;

import object.Episode.Episode;
import object.Episode.EpisodeClass;
import object.Event.Event;

public class ShowClass implements Show {
	
	Map<Integer, List<Episode>> episodesPerSeason; // <TEMPORADA,EPISODIOS>
	Map<String, Personagem> characters; // a collection of characters featuring the show

	private int totalEpisodeCount;
	private String name;
	private int numberOfSesons;
	private List<Episode> episodes;
	
	public ShowClass(String name) {
		this.name = name;
		totalEpisodeCount = 0;

		episodesPerSeason = new TreeMap<Integer,List<Episode>>(); //
		numberOfSesons = 1; // Um show ja comeca com uma temporada pronta
		episodes = new ArrayList<Episode>(); // e um aray de episodios, logo de cara
		episodesPerSeason.put(numberOfSesons, episodes); //
		characters = new TreeMap<String, Personagem>();

	}

	public String getShowName() {
		return name;
	}

	public int getNumberOfSeasons() {
		return numberOfSesons;
	}

	public int getAllEpisodesNumber() {
		return totalEpisodeCount;
	}

	public void addCharacter(Personagem act){
			characters.put(act.getCharacterName(), act);
	}

	public void addSeason() {
		numberOfSesons++;
		List<Episode> episodes = new LinkedList<Episode>();
		episodesPerSeason.put(numberOfSesons, episodes);
	}

	public Map<Integer, List<Episode>> getEpisodesPerSeason() {
		return episodesPerSeason;
	}
	
	public void addEpisodeToSeason(int season, String episodeName) {
		totalEpisodeCount++;
		Episode p = new EpisodeClass(episodeName,episodesPerSeason.get(season).size() + 1, season);
		episodesPerSeason.get(season).add(p);
	}
	/*Considering that the relation is transitive mutual*/
	public boolean areTheseTwoRelated(String personName1, String personName2) {
		return getThisCharacter(personName1).isMyParent(personName2) || getThisCharacter(personName1).isMySon(personName2);
	}
	public boolean areTheseTwoRomantic(String character1, String character2) {
		return getThisCharacter(character1).isMyRomanticPartner(character2);	
	}
	
	//this method only chekck family relationship until the 4 generation
	public Iterator<Personagem> howAreTheseTwoRelated(String avo, String neto) {
		List<Personagem> relateP = new ArrayList<>();
		Personagem old = getThisCharacter(avo);
		Personagem young = getThisCharacter(neto);
		if(old.isMySon(neto)) {
			relateP.add(old);
			relateP.add(young);
			return relateP.iterator();
		}else {
			Iterator<Personagem> filhos = old.iterateSons();
			while(filhos.hasNext()) {
				Personagem ff = filhos.next();
				if(ff.isMySon(neto)) {
					relateP.add(old);
					relateP.add(ff);
					relateP.add(young);
					return relateP.iterator();
				}else {
					Personagem nn = isMySon(ff.iterateSons(), neto);
					if(nn!=null) {
						relateP.add(old);
						relateP.add(ff);
						relateP.add(nn);
						relateP.add(young);
						return relateP.iterator();
					}
				}
			}
		}
		//checks if neto if avo's father
		if(old.isMyParent(neto)) {
			relateP.add(young);
			relateP.add(old);
			return relateP.iterator();
		}else {
			
			Iterator<Personagem> pais = old.iterateParents();
			while(pais.hasNext()){
				Personagem gFather = pais.next();
				//checks if neto is the father of any of avo's father 
				if(gFather.isMyParent(neto)) {
					relateP.add(young);
					relateP.add(gFather);
					relateP.add(old);
					return relateP.iterator();
				}else {
					Personagem dd = isMyFather(gFather.iterateParents(), neto);
					// so on
					if(dd!=null) {
						relateP.add(young);
						relateP.add(dd);
						relateP.add(gFather);
						relateP.add(old);
						return relateP.iterator();
					}
				}
			}
		}
		return null;
	}
	
	private Personagem isMySon(Iterator<Personagem> per,String son) {
		while(per.hasNext()) {
			Personagem nn = per.next();
			if(nn.isMySon(son)) {
				return nn;
			}
		}
		return null;
	}
	private Personagem isMyFather(Iterator<Personagem> per,String dad) {
		while(per.hasNext()) {
			Personagem nn = per.next();
			if(nn.isMyParent(dad)) {
				return nn;
			}
		}
		return null;
	}
	
	public Iterator<Personagem> famousQuotes(String quote){
		List<Personagem> quotes = new ArrayList<Personagem>();
		Iterator<Personagem> it = characters.values().iterator();
		while(it.hasNext()) {
			Personagem pp = it.next();
			if(pp.getThisQuote(quote)!=null) {
				quotes.add(pp);
			}
		}
		if(quotes.size()==0) {
			return null;
		}
		return quotes.iterator();
	}
	
	public boolean ThereThisCharacter(String player) {
		return getThisCharacter(player)!=null;
	}
	public Personagem getThisCharacter(String character) {
		Iterator<Personagem> it = characters.values().iterator();
		while(it.hasNext()) {
			Personagem u = it.next();
			if(u.getCharacterName().equalsIgnoreCase(character)) {
				return u;
			}
		}
		return null;
	}
//	public boolean thisActorHasRelation(String actorName) {
//		Iterator<Personagem> pp = iterateAllCharacters();
//		while(pp.hasNext()) {
//			Personagem r = pp.next();
//			if(r.getCharacterName().equalsIgnoreCase(actorName)&&r.getLovers().size()!=0) {
//				return true;
//			}
//		}
//		return false;
//	}
	public void updateSiblings(Personagem parent) {
		Iterator<Personagem> it = characters.values().iterator();
		while(it.hasNext()) {
			Personagem per = it.next();
			if(per.isMyParent(parent.getCharacterName())) {
				per.addSibling(parent);
			}
		}
	}
	public Iterator<Personagem> iterateAllCharacters(){
		return characters.values().iterator();
	}
	public List<Episode> getThisSeason(int seasonNum){
		return episodesPerSeason.get(seasonNum);
	}
	public void addEvent(int season, int episode, Event event, String [] playersNames) {
	 List<Episode> p =	episodesPerSeason.get(season);
	 Episode e = p.get(episode-1);
	 e.addEvent(event, playersNames);
	}
//	public void addEpisodeToACharacter(String character, int season, int episode) {
//		List<Episode> p=episodesPerSeason.get(season);
//		 Episode e = p.get(episode-1);
//		getThisCharacter(character).getMyEpisodes().add(e);
//	}
	public Iterator<Episode> getEpisodes(int season){
		return episodesPerSeason.get(season).iterator();
	}
	public Iterator<Integer> iterateSeasons(){
		return episodesPerSeason.keySet().iterator();
	}
	/**
	 * looks for a String key in the map, ignoring string's cases
	 * 
	 * @param showName
	 * @return
	 */
	private String mapContainsThisKey(String showName) {
		Set<String> c = characters.keySet();
		for (String string : c) {
			if (showName.equalsIgnoreCase(string)) {
				return string;
			}
		}
		return null;
	}
}
