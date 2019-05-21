package object.Quote;

public class QuoteClass implements Quote {

	private int season;
	private int episode;
	private String character;
	private String quote;

	public QuoteClass(int season, int episode, String character, String quote) {
		this.season = season;
		this.episode = episode;
		this.character = character;
		this.quote = quote;
	}
	public int getSeason() {
		return season;
	}
	public int getEpisode() {
		return episode;
	}
	public String getCharacter() {
		return character;
	}
	public String getQuote() {
		return quote;
	}
}
