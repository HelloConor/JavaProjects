import java.util.*;
public class ArrayListTest {

	public static void main(String[] args) {
		
		// fill a staff array three Employee objects
		ArrayList<Employee>  staff = new ArrayList<Employee>();
		
		staff.add(new Employee("Tony Tiger", 40000, 2005, 03, 02));
		staff.add(new Employee("Mark Brown", 35000, 2007, 02,07));
		staff.add(new Employee("Jeremy Blunt", 60000, 2003, 01, 19));
		
		// raise everyone's salary by 5%
		for (Employee e : staff)
			e.raiseSalary(5);
		
		for (Employee e: staff)			
			System.out.println("name= " + e.getName() + "salary= " + e.getSalary() + "hireDay= " + e.getHireDay());
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
	
	private String name;
	private double salary;
	private Date hireDay;
	
}