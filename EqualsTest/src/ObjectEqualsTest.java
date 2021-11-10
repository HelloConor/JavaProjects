import java.util.*;
public class ObjectEqualsTest {

	public static void main(String[] args) {
		
		Employee alice1 = new Employee("Alice Adams", 75000, 2002, 04, 05);
		Employee alice2 = alice1;
		Employee alice3 = new Employee("Alice Adams", 75000, 2002, 04, 05);
		Employee bob = new Employee("Bob Brandson", 50000, 2004, 05, 03);
		
		System.out.println("alice1 == alice2: " + (alice1 == alice2));
		
		System.out.println("alice1.equals(alice3): " + alice1.equals(alice3));
		
		System.out.println("alice1.equals(bob): " + alice1.equals(bob));
		
		System.out.println("bob.toString(): " + bob);
		
		Manager carl = new Manager("Carl Cracker", 80000, 1998, 12, 05);
		Manager boss = new Manager("Carl Cracker", 80000, 1998, 12, 05);
		boss.setBonus(5000);
		System.out.println("boss.toString() " + boss);
		System.out.println("carl.equals(boss) " + carl.equals(boss));
		System.out.println("alice1.hashCode() " + alice1.hashCode());
		System.out.println("alice3.hashCode() " + alice3.hashCode());
		System.out.println("bob.hashCode() " + bob.hashCode());
		System.out.println("carl.hashCode() " + carl.hashCode());

	}

}

class Employee {
	public Employee(String n, double s, int year, int month, int day) {
		
		name = n;
		salary = s;
		GregorianCalendar calendar = new GregorianCalendar(year, month -1, day);
		hireDay = calendar.getTime();
	}
	
	public String getName() {
		return name;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public Date getHireDay() {
		return hireDay;
	}
	
	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}
	
	public boolean equals(Object otherObject) {
		
		// quick test to see if they are identical
		if (this == otherObject) return true;
		// must return false if explicit parameter is null
		if (otherObject == null) return false;
		// if the classes don't match they can't be equal
		if (getClass() != otherObject.getClass()) return false;
		// now we know otherObject is a non-null Employee
		Employee other = (Employee) otherObject;
		// test whether the fields have identical values
		return name.equals(other.name) && salary == other.salary && hireDay.equals(other.hireDay);
	}
	
	
	private String name;
	private double salary;
	private Date hireDay;
}

class Manager extends Employee {
	public Manager(String n, double s, int year, int month, int day ) {
		
		super(n, s, year, month, day);
		bonus = 0;
	}
	
	public double getSalary() {
		
		double baseSalary = super.getSalary();
		return baseSalary + bonus;
	}
	
	public void setBonus(double b) {
		bonus = b;
	}
	
	public boolean equals(Object otherObject) {
		
		if (!super.equals(otherObject)) return false;
		Manager other = (Manager) otherObject;
		// super.equals checked that this and the other belong to the same class
		return bonus == other.bonus;
	}
	
	//public int hashCode() {
	//	return super.hashCode() + 17 * new Double(bonus).hashCode();
	//}
	
	public String toString() {
		return super.toString() + "[bonus= " + bonus + "]";
	}
	
	
	private double bonus;
}