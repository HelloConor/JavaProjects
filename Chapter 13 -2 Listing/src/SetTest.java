import java.util.*;
public class SetTest {
	
	// this program uses a set to print out all unique words in System.in

	public static void main(String[] args) {
		
		Set<String> words = new HashSet<String>(); // HashSet implements Set
		long totalTime = 0;
		
		Scanner in = new Scanner(System.in);
		while (in.hasNext())
		{
			String word = in.next();
			long callTime = System.currentTimeMillis();
			words.add(word);
			callTime = System.currentTimeMillis() - callTime;
			totalTime += callTime;
		}
		
		Iterator<String> iter = words.iterator();
		for (int i = 1; i <= 30 && iter.hasNext(); i++)
			// change the second part of the foor loop to determine how many unqiue words to print
			System.out.println(iter.next());
		System.out.println(". . .");
		System.out.println(words.size() + " distinct words. " + totalTime + " miliseconds. ");

	}

}

// run this in terminal: java SetTest.java < alice30.txt
// This measures how many unique words are found in alice30.txt and how fast it took to return the number
// make sure you are in the directionary of where these files are located 