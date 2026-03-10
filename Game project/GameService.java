package gameProject;

import java.util.List;
import java.util.ArrayList;

public class GameService {
	static ArrayList<Game> games = new ArrayList<>();

	public GameService() {

		if (games.isEmpty()) {
			games.add(new Game("SnowBird", "Danny", 300));
			games.add(new Game("FreshFood", "Ram", 450));
			games.add(new Game("Batsman", "Kate", 400));
			games.add(new Game("Pokiman", "Steeve", 600));
			games.add(new Game("YammyTommy", "Narayan", 350));
		}
	}

	// view all games
	public List<Game> viewAll() {
		return games;
	}

	// search by author
	public String authorSearch(String author) {

		for (Game game : games) {
			if (author.equals(game.getAuthorName())) {
				return game.getGameName();
			}
		}
		return "NOT FOUND";
	}
}
