package com.semanticsquare.basics;

class Student{
	static int no_of_students = 0;
	/*
	short rank = 9_3_0_2;
	long phone = 678_838_3220L;//can use underscore	
	//id = 1001;
	*/

	int id = 1000; 
	int age = 62;
	String name;	
	double tuition_fees = 12000.0,international_fees = 5000.0;
	boolean international;
	Student(){}

	Student(int id,String name, int age){
		this(id, name, age, false);
		
	}
	Student(int id,String name, int age, boolean international){
		this.id = id;
		this.name = name;
		this.age = age;
		this.international = international;
		no_of_students+=1;
		if(this.international) tuition_fees +=international_fees;
		this.compute();
	}
	
	void compute(){
		//int nextid = id+1;
		System.out.println("\nid: "+id);
		System.out.println("name: "+name);		
		//System.out.println(nextid);
		System.out.println("age : "+age);
		//System.out.println("rank : " +rank);
		//System.out.println("phone : " + phone);
		System.out.println("tuition_fees: "+tuition_fees);
		//System.out.println("internation_fees: "+ internation_fees);
		
	}
		
	static Student s2;

	public static void main(String[] args){
	
		Student s = new Student(1,"Dheeru",26);
		Student s2 = new Student(2,"Sach",20);
		Student s3 = new Student();
		System.out.println("No of Students: "+Student.no_of_students);
		Student s4 = new Student();
	}
}
