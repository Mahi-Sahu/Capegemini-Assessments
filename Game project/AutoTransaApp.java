package gameProject;

import java.util.List;
import java.util.Scanner;

public class AutoTransaApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		User user = new User();
		GameService service = new GameService();

		int choice;

		do {
			System.out.println("\n===== MAIN MENU =====");
			System.out.println("1) RegisterUser");
			System.out.println("2) ViewGames");
			System.out.println("3) searchByName");
			System.out.println("4) Exit");
			System.out.print("Enter choice: ");

			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {

			case 1:
				System.out.print("Enter userid: ");
				String uid = sc.nextLine();

				System.out.print("Enter password: ");
				String pwd = sc.nextLine();

				user.addUser(uid, pwd);
				break;

			case 2:
				List<Game> list = service.viewAll();
				list.forEach(System.out::println);
				break;

			case 3:
				System.out.print("Enter author name: ");
				String author = sc.nextLine();

				String result = service.authorSearch(author);
				System.out.println(result);
				break;

			case 4:
				System.out.println("Exiting...");
				break;

			default:
				System.out.println("Invalid choice");
			}

		} while (choice != 4);

		sc.close();
	}
}
