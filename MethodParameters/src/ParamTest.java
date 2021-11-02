
public class ParamTest {

	public static void main(String[] args) {
		
		//test 1: Methods cannot modify numeric parameters
		System.out.println("Testing tripleValue");
		double percent = 10;
		System.out.println("Before: percent=" + percent);
		tripleValue(percent);
		System.out.println("After: percent=" + percent);
		
		// Test 2: Methods can change the state of object parameters
		System.out.println("\nTesting tripleSalary:");
		Employee harry = new Employee("Harry", 50000);
		System.out.println("Before: salary=" + harry.getSalary());
		tripleSalary(harry);
		System.out.println("After: salary=" + harry.getSalary());
		
		// Test 3: Methods cannot attach new objects to object parameters
		System.out.println("\nTesting swap:");
		Employee a = new Employee("Alice", 70000);
		Employee b = new Employee("Bob", 60000);
		System.out.println("Before: a=" + a.getName());
		System.out.println("Before: b=" + b.getName());
		swap(a,b);
		System.out.println("After: b=" + a.getName());
		System.out.println("After: b=" + b.getName());
	}
	
	public static void tripleValue(double x) { // does not work
		x = 3 * x;
		System.out.println("End of method: x=" + x);
	}
	public static void tripleSalary(Employee x) { // works
		x.raiseSalary(200);
		System.out.println("End of method: salary=" + x.getSalary());
	}
	public static void swap(Employee x, Employee y) {
		Employee temp = x;
		x = y;
		System.out.println("End of method: x=" + x.getName());
		System.out.println("End of method: y=" + y.getName());
	}
}

class Employee { // simple employee class

	public Employee(String n, double s) {
		name = n;
		salary = s;
	}
	public String getName() {
		return name;
	}
	public double getSalary() {
		return salary;
	}
	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}
	
	private String name;
	private double salary;
	

}
