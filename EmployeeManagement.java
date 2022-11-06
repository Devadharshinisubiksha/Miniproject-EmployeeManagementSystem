package com.java;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

class Employee implements Serializable{

	int id;
	String name;
	float salary;
	long contact_no;
	String email_id;
	
	public Employee(int id, String name, float salary, long contact_no, String email_id)
	{
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.contact_no = contact_no;
		this.email_id = email_id;
	}
	
	public String toString()
	{
		return "\nEmployee Details :" + "\nID: " + this.id + "\nName: " + this.name + "\nSalary: " + 
				this.salary + "\nContact No: " + this.contact_no + "\nEmail-id: " + this.email_id;
	}	
}
public class EmployeeManagement
{	
	static void display(ArrayList<Employee> al)
	{
		System.out.println("Employee List");
		System.out.println(String.format("%-10s%-15s%-10s%-20s%-10s", "ID","Name","salary","contact-no","Email-Id"));
		for(Employee e : al)
		{
			System.out.println(String.format("%-5s%-20s%-10s%-15s%-10s",e.id,e.name,e.salary,e.contact_no,e.email_id));
		}
	}
	public static void main(String[] args)
	{
		int id;
		String name;
		float salary;
		long contact_no;
		String email_id;
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Employee> al = new ArrayList<Employee>();
			
		do
		{
			System.out.println("Welcome to the Employee Management System");
			System.out.println("1). Add Employee to the DataBase" );
			System.out.println("2). Search for Employee ");
			System.out.println("3). Edit Employee details"); 
			System.out.println("4). Delete Employee Details"); 
			System.out.println("5). EXIT");
			System.out.println("Enter your choice : ");
			int ch = sc.nextInt();
			
			switch(ch)
			{
			case 1:System.out.println("Enter the following details to ADD list:");
				System.out.println("Enter ID :");
				id = sc.nextInt();
				System.out.println("Enter Name :");
				name = sc.next();
				System.out.println("Enter Salary :");
				salary = sc.nextFloat();
				System.out.println("Enter Contact No :");
				contact_no = sc.nextLong();
				System.out.println("Enter Email-ID :");
				email_id = sc.next();
				al.add(new Employee(id, name, salary, contact_no, email_id));
				display(al);
				break;
				
			case 2: System.out.println("Enter the Employee ID to search :");
					id = sc.nextInt();
					int i=0;
					for(Employee e: al)
					{
						if(id == e.id)
						{
							System.out.println(e);
							i++;
						}
					}
					if(i == 0)
					{
						System.out.println("Employee Details are not available, Please enter a valid ID");
					}
					break;
			
			case 3: System.out.println("Enter the Employee ID to EDIT the details");
					id = sc.nextInt();
					int j=0;
					for(Employee e: al)
					{
						if(id == e.id)
						{	
							j++;
						do{
							int ch1 =0;
							System.out.println("EDIT Employee Details :"); 
							System.out.println("1). Employee ID" );
							System.out.println("2). Name" );
							System.out.println("3). Salary");
							System.out.println("4). Contact No");
							System.out.println("5). Email-ID"); 
							System.out.println("6). GO BACK");
							System.out.println("Enter your choice : ");
							ch1 = sc.nextInt();
							switch(ch1)
							{
							case 1: System.out.println("Enter new Employee ID:");
									e.id =sc.nextInt();
									System.out.println(e);
									break;
							
							case 2: System.out.println("Enter new Employee Name:");
									e.name =sc.nextLine();
									System.out.println(e);
									break;
									
							case 3: System.out.println("Enter new Employee Salary:");
									e.salary =sc.nextFloat();
									System.out.println(e);
									break;
									
							case 4: System.out.println("Enter new Employee Contact No. :");
									e.contact_no =sc.nextLong();
									System.out.println(e);
									break;
									
							case 5: System.out.println("Enter new Employee Email-ID :");
									e.email_id =sc.next();
									System.out.println(e);
									break;
									
							case 6: j++;
									break;
									
							default : System.out.println("Enter a correct choice from the List :");
										break;
							
							}
							}
						while(j==1);
						}
					}
					if(j == 0)
					{
						System.out.println("Employee Details are not available, Please enter a valid ID");
					}
				
					break;
					
			case 4: System.out.println("Enter Employee ID to DELETE from the Databse :");
					id = sc.nextInt();
					int k=0;
					try{
						for(Employee e: al)
						{
							if(id == e.id)
							{
									al.remove(e);
									display(al);
									k++;
							}
						}
						if(k == 0)
						{
							System.out.println("Employee Details are not available, Please enter a valid ID!!");
						}
						}
						catch(Exception e1){
							System.out.println(e1);
						}
					break;
			case 5:
				System.out.println("Exit from employee database");
				break;
				
			default : System.out.println("Enter a correct choice from the List :");
			break;
			
			}
		}
		while(true);
	}
}