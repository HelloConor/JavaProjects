import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class methodsums {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please give four numbers:");
		int numberone = Integer.valueOf(scanner.nextLine());
		int numbertwo = Integer.valueOf(scanner.nextInt());
		int numberthree = Integer.valueOf(scanner.nextInt());
		int numberfour = Integer.valueOf(scanner.nextInt());

		int addition = sum(numberone, numbertwo, numberthree, numberfour);
		int small = smallest(numberone, numbertwo, numberthree, numberfour);
		int large = largest(numberone, numbertwo, numberthree, numberfour);
		double avg = average(numberone, numbertwo, numberthree, numberfour);
				
		System.out.println("Sum: " + addition);
		System.out.println("Smallest number: " + small);
		System.out.println("Largest number: " + large);
		System.out.println("Average number: " + avg);
		
	}
	
	public static int sum (int numberone, int numbertwo, int numberthree, int numberfour) {		
		int sum = numberone + numbertwo + numberthree + numberfour;
		return sum;
	}
	
	public static int smallest (int numberone, int numbertwo, int numberthree, int numberfour) {
		List<Integer> mySet = Arrays.asList(numberone, numbertwo, numberthree, numberfour);	
		int smallest = Collections.min(mySet);
		return smallest;
	}
	
	public static int largest (int numberone, int numbertwo, int numberthree, int numberfour) {
		List<Integer> mySetTwo = Arrays.asList(numberone, numbertwo, numberthree, numberfour);	
		int largest = Collections.max(mySetTwo);
		return largest;
	}
	
	public static double average(int numberone, int numbertwo, int numberthree, int numberfour) {
		double average = sum(numberone, numbertwo, numberthree, numberfour) / (double) 4;
		return average;
	}
	
		
}
