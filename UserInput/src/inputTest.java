import java.util.Scanner;

public class inputTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Hello there, what is your name?\n");
		String username = scanner.nextLine();
		System.out.println(username + "?" + " that's a lovely name");
		System.out.println("How old are you, " + username + "?\n");
		String age = scanner.nextLine();
		int ageint = Integer.parseInt(age);
		if (ageint <= 20) {
			System.out.println(ageint + "!" + "Oh, to be so young again...");			
		}
		if (ageint > 20 && ageint <= 30) {
			System.out.println("Oh so you're a young professional then? Good for you");
		}
		if (ageint > 30 && ageint <=40) {
			System.out.println("a mature age, for a mature person I assume?");
		}
		else if (ageint > 40) {
			System.out.println("What life experience you must have.");
		}
		System.out.println("Thanks! Test complete");
		
		
		// TODO Auto-generated method stub

	}

}
