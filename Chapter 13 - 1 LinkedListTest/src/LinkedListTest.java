import java.util.*;


public class LinkedListTest {

	public static void main(String[] args) {
		
		List<String> a = new LinkedList<String>();
		a.add("Amy");
		a.add("Anna");
		a.add("Amelia");
		
		List<String> b = new LinkedList<String>();
		b.add("Bob");
		b.add("Bobo");
		b.add("Beau");
		
		System.out.println(a);
		System.out.println(b);
		
		// merge the words from b into a
		
		ListIterator<String> aIter = a.listIterator();
		Iterator<String> bIter = b.listIterator();
		
		while (bIter.hasNext())
		{
			if (aIter.hasNext()) aIter.next();
			aIter.add(bIter.next());
		}
		
		System.out.println(a);
		
		// Remove every second word from b
		
		bIter = b.iterator();
		while (bIter.hasNext());
		{
			bIter.next(); // skip one element
			if (bIter.hasNext())
			{
				bIter.next(); // skip next element
				bIter.remove(); // remove that element
			}
		}
		
		System.out.println(b);
		
		// bulk operation: remove all words in b from a
		
		a.removeAll(b);
		
		System.out.println(a);

	}

}
