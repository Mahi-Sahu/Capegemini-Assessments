package gameProject;

public class Game {
	private String gameName;
	private String authorName;
	private float price;

	// default constructor
	public Game() {
	}

	// parameterized constructor
	public Game(String gameName, String authorName, float price) {
		this.gameName = gameName;
		this.authorName = authorName;
		this.price = price;
	}

	// getters and setters
	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Game [gameName=" + gameName + ", authorName=" + authorName + ", price=" + price + "]";
	}
}
