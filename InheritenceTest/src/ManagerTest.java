import java.util.*;
public class ManagerTest {

	public static void main (String[] args) {
		
		// construct a Manage object
		Manager boss = new Manager("Richard King", 70000, 1987, 12, 03);
		boss.setBonus(5000);
		
		// a director object 
		Director exec = new Director("Robert Frost", 100000, 1988, 04, 02);
		exec.setBonus(20000);
		
		Employee[] staff = new Employee[4];
		
		staff[0] = boss;
		staff[1] = new Employee("Harry Tacker", 40000, 1990, 04, 05);
		staff[2] = new Employee("Megan Smith", 35000, 1992, 05, 01);
		staff[3] = exec;
		
		for (Employee e : staff) 
			System.out.println("Name=" + e.getName() + ",Salary=" + e.getSalary());
				
			
	}
	
}
class Employee {
	
	public Employee(String aName, double aSalary, int year, int month, int day) {
		
		name = aName;
		salary = aSalary;
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
	
	public void raiseSalary(double ByPercent) {
		double raise = salary * ByPercent /100;
		salary += raise;
	}
	
	private String name;
	private double salary;
	private Date hireDay;	
}

class Manager extends Employee {
	// Manager inherits the methods made in the Employee class, can reuse them to save code
	
	public Manager(String aName, double aSalary, int year, int month, int day) {
		
		super(aName, aSalary, year, month, day);
		bonus = 0;		
	}
	public double getSalary() {
		// super refers to calling the method made in the Employee class 
		double baseSalary = super.getSalary();
		return baseSalary + bonus;
	}
	public void setBonus(double b) {
		bonus = b;
	}
	
	private double bonus;
			
}

class Director extends Employee {
	
	public Director(String aName, double aSalary, int year, int month, int day) {
		
		super(aName, aSalary, year, month, day);
		bonus = 0;		
	}
	public double getSalary() {
		double baseSalary = super.getSalary();
		return baseSalary + bonus;
	}
	public void setBonus(double b) {
		bonus = b;
	}
	
	private double bonus;

}


