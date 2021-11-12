import java.util.Scanner;

public class EnumTest {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Hey, lets get coffee. Where shall we go?");
		System.out.println("Enter a shop: STARBUCKS, COSTA, PRET)");
		String coffeeChoice = scanner.next().toUpperCase();
		Shop shop = Enum.valueOf(Shop.class, coffeeChoice);
		System.out.println("Shop=" + shop);
		System.out.println("Response=" + shop.getCoffeeTalk());
		
		System.out.println("What size are you going to get?");
		System.out.println("Enter a size: (SMALL, MEDIUM, LARGE, EXTRA_LARGE)");
		String input = scanner.next().toUpperCase();
		Size size = Enum.valueOf(Size.class, input);
		System.out.println("size=" + size);
		System.out.println("abbreviation=" + size.getAbbreviation());
		if (size == Size.EXTRA_LARGE)
			System.out.println("Thats a lot, you must be really craving coffee");
		if (size == Size.LARGE)
			System.out.println("A strong amount for sure");
		if (size == Size.MEDIUM)
			System.out.println("A standard size, I may have the same honestly");
		if (size == Size.SMALL)
			System.out.println("You cutting back caffeine? I should too probably.");
			
	}
}

enum Size {
	SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");
	
	private Size(String abbreviation) {this.abbreviation = abbreviation;}
	public String getAbbreviation() {return abbreviation;}
	
	private String abbreviation;
}

enum Shop {
	STARBUCKS("I like the coffee there too"), COSTA("Good value, and tasty"), PRET("I've never been there, we should try it out");
	
	private Shop(String coffeeTalk) {this.coffeeTalk = coffeeTalk;}
	public String getCoffeeTalk() {return coffeeTalk;}
	
	private String coffeeTalk;
}
