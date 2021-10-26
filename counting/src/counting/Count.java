package counting;

import java.util.Scanner;

public class Count {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    // asks for user input and saved into integer called 'input'
    System.out.println("Please enter a number, this program will count from 0 and then print your number");
    int input = scanner.nextInt();

    // for loop. i is equal to 0; while i (0) is less or equal to user input add 1 to i.
    for (int i = 0; i <= input; i++) {
      // print out i until it reaches the user inputted number
      System.out.println(i);

    }

    System.out.println("Please enter a second number");
    int input2 = scanner.nextInt();

    for (int j = 0; j <= input2; j++) {
      System.out.println(j);
    }
    
    int sum = input + input2;
    System.out.println("These numbers equal: " + sum);
    System.out.println("I will now count until this new number is reached");
    
    for (int a = 0; a <= sum; a++) {
    	System.out.println(a);
    }


      
    

  }
}
