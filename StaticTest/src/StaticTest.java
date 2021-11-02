
public class StaticTest {

	public static void main(String[] args) {
		// fill the staff array with three employee objects
		Employee[] staff = new Employee[3];
		
		staff[0] = new Employee("Tom", 40000);
		staff[1] = new Employee("Dick", 60000);
		staff[2] = new Employee("Harry", 70000);
		
		//print out information on all employee objects
		for (Employee e : staff) {
			e.setId();
			System.out.println("Name: " + e.getName() + ", ID: " + e.getId() + ", Salary: " + e.getSalary());
		}

	}

}

class Employee {
	
	public Employee(String n, double s) {
		name = n;
		salary = s;
		// id starts at 0 so the first employee can be ID 1, and then following incremented by 1 so they are in order
		id = 0;
	}
	
	public String getName() {
		return name;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public int getId() {
		return id;
		
	}
	
	
	public void setId()
	{
		id = nextId; // set id next to avaliable id
		// id starts at 0 as stated at top of Employee class
		// we are incrementing by 1 so the Employee objects have ID increased by 1 in order. 
		// I.E Tom will be ID 1, Dick will be ID 2, and Harry will be I
		nextId++;
	}
	public static int getNextId() {
		// this is static so each ID is unique, it it was not then all IDs would be 1
		// every employee object has its own ID field, but the static nextID belongs to the class, not the methods.
		return nextId; // returns static field 
	}
	
	
	
	private String name;
	private double salary;
	private int id;
	private static int nextId = 1;
	
}