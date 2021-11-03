import java.util.*;

public class ConstructorTest {

	public static void main(String[] args) {
		
		// three employee objects
		Employee[] staff = new Employee[3];
		
		staff[0] = new Employee("Harry", 40000);
		staff[1] = new Employee(60000);
		staff[2] = new Employee();
		
		// print out information for employee obects
		for (Employee e: staff)
			System.out.println("name=" + e.getName() + ", id=" + e.getId() + ", salary=" + e.getSalary());

	}

}

class Employee {
	
	// three overloaded constructors 
	public Employee(String aName, double aSalary) {
		name = aName;
		salary = aSalary;
	}
	public Employee(double aSalary) {
		// calls the Employee(String, double) constructor
		this("Employee #" + nextId, aSalary);
	}
	
	public Employee() {
		// this is a default constructor as it has no parameters
		// this would set all instance fields to their default values	
		
		// name initialized to "" -- see below
		// salary not explicity set -- initialized to 0
		// id initialized in initializatin block
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
	
	private static int nextId;
	private int id;
	private String name = ""; // instance field initializion
	private double salary;
	
	static {
		Random generator = new Random();
		// set nextId to a random number between 0 and 9999
		nextId = generator.nextInt(1000);
		}
	
	// object initialization block
	{
		id = nextId;
		nextId++;
	}
	
	
	
	
}


