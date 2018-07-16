package com.ds.structural;

import java.util.ArrayList;
import java.util.List;

public class AdapterPattern {
	public static void main(String[] args) {
		List<Employee> employeeList = new ArrayList<>();
		
		Employee employeeDB = new EmployeeDB(1, "Saurav", "Satrawal");
		EmployeeLdap employeeLdap = new EmployeeLdap(2, "Saurav", "Satrawal");		// Non-Employee instance
		
		// Simple
		employeeList.add(employeeDB);
		
		// Usage of adapter
		// employeeList.add(employeeLdap);			// Won't compile
		employeeList.add(new EmployeeAdapter(employeeLdap));
	}
}

/**
 * @author sauravsatrawal
 */
interface Employee {
	int getId();
	String getFirstName();
	String getLastName();
}

/**
 * @author sauravsatrawal
 */
class EmployeeDB implements Employee {
	private int id;
	private String firstName;
	private String lastName;
	
	public EmployeeDB(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@Override
	public int getId() {	return id;	}
	@Override
	public String getFirstName() {	return firstName; }
	@Override
	public String getLastName() {	return lastName;	}
}

/**
 * @author sauravsatrawal
 */
class EmployeeLdap {		// Doesn't implements Employee
	private int cn;
	private String fName;
	private String lName;
	
	public EmployeeLdap(int cn, String fName, String lName) {
		this.cn = cn;
		this.fName = fName;
		this.lName = lName;
	}
	
	public int getCn() {	return cn;		}
	public String getfName() {	return fName;	}
	public String getlName() {	return lName;	}
}

/**
 * ADAPTER CLASS
 */
class EmployeeAdapter implements Employee {
	private EmployeeLdap instance;
	
	public EmployeeAdapter(EmployeeLdap instance) {
		this.instance = instance;
	}
	public int getId() {	return instance.getCn();	}
	public String getFirstName() {	return instance.getfName();	}
	public String getLastName() {	return instance.getlName();	}
}