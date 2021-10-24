package likedBooks;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class faveBooks {

	public static void main(String[] args) {
		List<String> bookList = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please type three books you like, what is the first?");
		String book1 = scanner.nextLine();
		bookList.add(book1);
		System.out.println("What's your second?");
		String book2 = scanner.nextLine();
		bookList.add(book2);
		System.out.println("And what is your third?");
		String book3 = scanner.nextLine();
		bookList.add(book3);
		System.out.println("Great, here is your top three books you like:");
		System.out.println(bookList);
		
		
		
		

	}

}
