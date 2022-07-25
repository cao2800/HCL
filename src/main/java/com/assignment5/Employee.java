package com.assignment5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Employee {
	int empID;
	String empName;
	int empAge;
	String empGender;
	String dept;
	int yearOfJoining;
	int empSalary;
	 
	public Employee(int empID, String empName, int empAge, String empGender, String dept, int yearOfJoining,
			int empSalary) {
		super();
		this.empID = empID;
		this.empName = empName;
		this.empAge = empAge;
		this.empGender = empGender;
		this.dept = dept;
		this.yearOfJoining = yearOfJoining;
		this.empSalary = empSalary;
	}

	public int getEmpID() {
		return empID;
	}

	public String getEmpName() {
		return empName;
	}

	public int getEmpAge() {
		return empAge;
	}

	public String getEmpGender() {
		return empGender;
	}

	public String getDept() {
		return dept;
	}

	public int getYearOfJoining() {
		return yearOfJoining;
	}

	public int getEmpSalary() {
		return empSalary;
	}
	@Override
	public String toString() {
		return "Employee ID: " + empID
				+ ", Employee Name: " + empName 
				+ ", Employee Age: " + empAge 
				+ ", Employee Gender: " + empGender 
				+ ", Employee Department: " + dept
				+ ", Employee Year of Joining: " + yearOfJoining
				+ ", Employee Salary: " + empSalary;
				
	}
	
	public static void main(String[] args) {
		List<Employee> empList = new ArrayList<>();
		
		empList.add(new Employee(111, "Claudio Ordaz", 22, "Male", "Development", 2022, 58000));
		empList.add(new Employee(112, "Anissa Johnson", 25, "Female", "Development", 2020, 96000));
		empList.add(new Employee(113, "Catalina Rodriguez", 24, "Female", "Sales", 2022, 65000));
		empList.add(new Employee(114, "Carlos Rodriguez", 31, "Male", "Development", 2019, 60000));
		empList.add(new Employee(115, "Ben White", 40, "Male", "Sales", 2018, 76000));
		empList.add(new Employee(116, "Patrick Carlton", 35, "Male", "Development", 2021, 63000));
		
		// i) How many male and female employees are there in this organization?
		Map<String, Long> genderCount = empList.stream().collect(Collectors.groupingBy(Employee::getEmpGender, Collectors.counting()));
		System.out.println(genderCount);
		System.out.println();
		
		// ii) Find out Average age of male and female emps?
		Map<String, Double> avg = empList.stream().collect(Collectors.groupingBy(Employee::getEmpGender, Collectors.averagingDouble(Employee::getEmpAge)));
		System.out.println(avg);
		System.out.println();
		
		// iii) Find the highest paid employee in this org?
		Optional<Employee> highestPaidEmp = empList.stream().collect(Collectors.maxBy(Comparator.comparingInt(Employee::getEmpSalary)));
		Employee highestPaidEmployee = highestPaidEmp.get();
		System.out.println("Employee Salary:$" + highestPaidEmployee.getEmpSalary()
		+ " Employee ID:" + highestPaidEmployee.getEmpID()
		+ " Employee Name:" + highestPaidEmployee.getEmpName()
		+ " Employee Age:" + highestPaidEmployee.getEmpAge()
		+ " Employee Gender:" + highestPaidEmployee.getEmpGender()
		+ " Employee Department:" + highestPaidEmployee.getDept()
		+ " Employee Year of Joining:" + highestPaidEmployee.getYearOfJoining());
		System.out.println();
		
		// iv) List all te names of employee who has joined after 2015?
		empList.stream().filter(e -> e.getYearOfJoining() > 2015).map(Employee::getEmpName).forEach(System.out::println);
		System.out.println();
		
		// v) Find out the senior most employee in this org?
		Optional<Employee> seniorMostEmp = empList.stream().sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst();
		Employee seniorMostEmployee = seniorMostEmp.get();
		System.out.println("Employee Year of Joining:" + seniorMostEmployee.getYearOfJoining()
		+ " Employee ID:" + seniorMostEmployee.getEmpID()
		+ " Employee Name:" + seniorMostEmployee.getEmpName()
		+ " Employee Age:" + seniorMostEmployee.getEmpAge()
		+ " Employee Gender:" + seniorMostEmployee.getEmpGender()
		+ " Employee Department:" + seniorMostEmployee.getDept()
		+ " Employee Salary:$" + seniorMostEmployee.getEmpSalary());
		System.out.println();
		
		// vi)Count the number of emps in each department?
		Map<String, Long> empDeptCount = empList.stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.counting()));
		System.out.println(empDeptCount);
		System.out.println();
		
		// viii) Find  the average slary of male and female employees?
		Map<String, Double> avgSalary = empList.stream().collect(Collectors.groupingBy(Employee::getEmpGender, Collectors.averagingDouble(Employee::getEmpSalary)));
		System.out.println(avgSalary);
		System.out.println();
		
		// ix) Differentiat eht the employees who are younger or equal to 30 yrs from those employees    who older than 25 years
		Map<Boolean, List<Employee>> empEqualOrYounger = empList.stream().collect(Collectors.partitioningBy(e -> e.getEmpAge() <= 30 ));
		Map<Boolean, List<Employee>> empOlder = empList.stream().collect(Collectors.partitioningBy(e -> e.getEmpAge() > 25));
		Set<Entry<Boolean, List<Employee>>> entrySet1 = empEqualOrYounger.entrySet();
		Set<Entry<Boolean, List<Employee>>> entrySet2 = empOlder.entrySet();
		
		for(Entry<Boolean, List<Employee>> entry : entrySet1) {
			if(entry.getKey()) {
				System.out.println("Employees younger or equal to 30");
			}
			
			List<Employee> emp = entry.getValue();
			for(Employee e : emp) {
				System.out.println(e.getEmpName());
			}
		}
		
		System.out.println();
		for(Entry<Boolean, List<Employee>> entry : entrySet2) {
			if(entry.getKey()) {
				System.out.println("Employees older than 25");
			}
			
			List<Employee> emp = entry.getValue();
			for(Employee e : emp) {
				System.out.println(e.getEmpName());
			}
		}
		System.out.println();
		
		// x) List down the names of all employees in each department?
		Map<String, List<Employee>> empListInEachDept = empList.stream().collect(Collectors.groupingBy(Employee::getDept));
		Set<Entry<String, List<Employee>>> entrySet = empListInEachDept.entrySet();
		for (Entry<String, List<Employee>> entry : entrySet) {
			System.out.println(entry.getKey() + " Department");
			
			List<Employee> emp = entry.getValue();
			
			for(Employee e : emp) {
				System.out.println(e.getEmpName());
			}
		}
	}
}
	
