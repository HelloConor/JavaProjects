
import java.util.*;

public class AbstractPersonTest {

	public static void main(String[] args) {
		
		Person[] people = new Person[3];
		
		people[0] = new Employee("Harry Smith", 45000, 2005, 06, 12, "reading", "Manchester");
		people[1] = new Student("Gabriel Karski", "English Literature", "cinema", "London");
		people[2] = new Workout("Ken Williams", "Push, Pull, Legs", "mountaineering", "Liverpool");
				
		for (Person p : people)
			System.out.println(p.getName() + ", " + p.getDescription() + ", " + p.getFaveHobby() + ", " + p.getCity());
	}
}

abstract class Person {
	public Person(String aName, String aHobby, String aCity) {
		name = aName;
		hobby = aHobby;
		city = aCity;
				
	}
	
	public abstract String getDescription();
	//public abstract String getHobby();
	
	public String getName() {
		return name;		
	}
	
	public String getHobby() {
		return hobby;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getFaveHobby() {
		return getFaveHobby;
	}
	
	
	private String name;
	private String hobby;
	private String getFaveHobby;
	private String city;
	
}

class Employee extends Person {
	public Employee(String aName, double aSalary, int year, int month, int day, String aHobby, String aCity) {
		
		super(aName, aHobby, aCity);
		hobby = aHobby;		
		salary = aSalary;
		GregorianCalendar calendar = new GregorianCalendar(year, month -1, day);
		hireDay = calendar.getTime();
		city = aCity;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public Date getHireDay() {
		return hireDay;
	}
	
	public String getHobby() {
		return hobby;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getDescription() {
		return String.format("an employee with a salary of $%.2f", salary);
	}
	
	public String getFaveHobby() {
		return String.format("their favourite hobby is %s", hobby);
	}
	
	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}
	
	private double salary;
	private Date hireDay;	
	private String hobby;
	private String city;
}

class Student extends Person {
	
	public Student(String aName, String aDegree, String aHobby, String aCity) {
		// pass aName to superclass constructor
		super(aName, aHobby, aCity);
		hobby = aHobby;
		degree = aDegree;
		city = aCity;
	}
	
	public String getDescription() {
		return "a student studying a degree in " + degree;
	}
	
	public String getFaveHobby() {
		return String.format("their favourite hobby is %s", hobby);
	}
	
	
	private String degree;
	private String hobby;
	private String city;
}

class Workout extends Person {
	
	public Workout(String aName, String aRoutine, String aHobby, String aCity) {
		
		super(aName, aHobby, aCity);
		hobby = aHobby;
		routine = aRoutine;
	}
	
	public String getDescription() {
		return "a gym member which trains " + routine;
	}
	
	public String getFaveHobby() {
		return String.format("their favourite hobby is %s", hobby);
	}
	
	
	private String routine;
	private String hobby;
}


