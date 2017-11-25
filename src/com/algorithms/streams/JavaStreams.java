package com.algorithms.streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import java.util.stream.Collectors;

public class JavaStreams {

	
	public static class Employee {
		private String name;
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public int getSalary() {
			return salary;
		}

		public void setSalary(int salary) {
			this.salary = salary;
		}

		private int age;
		private int salary;
		
		public Employee(String n, int a, int s) {
			this.name = n;
			this.age = a;
			this.salary = s;
		}
		
		
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee e1 = new Employee("amit", 35, 120);
		Employee e2 = new Employee("tanya", 32, 170);
		Employee e3 = new Employee("vera", 36, 120);
		Employee e4 = new Employee("jim", 66, 150);
		
		List<Employee> eList = new ArrayList<>();
		eList.add(e1);
		eList.add(e2);
		eList.add(e3);
		eList.add(e4);
		
		List<Integer> e11 = eList.stream()
							.filter( e -> e.getSalary() > 130 )
							.sorted(Comparator.comparing(Employee::getSalary))
							.map(Employee::getAge)
							.collect(Collectors.toList());
		System.out.println(e11.toString());
		
		
	}

}
