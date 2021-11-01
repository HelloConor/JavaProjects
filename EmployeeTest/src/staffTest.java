import java.util.Date;
import java.util.GregorianCalendar;

public class staffTest {

	public static void main(String[] args) {
		
		// staff array with four employee objects
		Employee[] staff = new Employee[4];
		
		staff[0] = new Employee ("Richard Snow", "Developer", 40000, 12, 2005, 12, 06);
		staff[1] = new Employee ("Caroline Jones", "QA", 30000, 25, 2006, 04, 12);
		staff[2] = new Employee("Matthew James", "Project Lead", 50000, 16, 2004, 05, 02);
		staff[3] = new Employee("Lee Smith", "Assistant", 25000, 4, 2008, 03, 12);
		
		// this raises staff salaries by 5%
		for (Employee e : staff)
			e.raiseSalary(5);
		// this gives 3 more annual leave days to all staff
		for (Employee e : staff)
			e.addLeave();
		
		// prints out employee details
		for (Employee  e : staff)
			System.out.println("Name: " + e.getName() + ", Job: " + e.getJob() + ", Salary: " 
		    + e.getSalary() + ", Annual Leave Days: " + e.getAnnualLeave() + ", Hired: " + e.getHireDay());

	}

}

class Employee
{
	// this is the constructor
	// the data types are in order of the array employee details
	public Employee (String n, String j, double s, int al, int year, int month, int day) {
	
		name = n;
		salary = s;		
		job = j;
		leave = al;
		GregorianCalendar calendar = new GregorianCalendar(year, month -1, day);
		hireDay = calendar.getTime();
	}
	
	// this is a method 
	// these are public so any method in any class can call them, just like we do in the above class "staffTest".
	public String getName() {
		return name;
	}
	// another method
	public String getJob() {
		return job;
	}
	public int getAnnualLeave() {
		return leave;
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
	// this adds 3 extra days of annual leave
	public void addLeave() {
		int holidays = 3;
		leave = leave + holidays;
	}
	
	
	
	
	// these are private so only methods inside their own class can read them
	
	private String name;
	private double salary;
	private Date hireDay;
	private String job;
	private int leave;
}