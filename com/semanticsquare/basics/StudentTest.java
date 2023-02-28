package com.semanticsquare.basics;

class StudentTest{
	public static void main(String[] args){
		Student student1 = new Student(1,"Ansh",18);
		Student student2 = new Student(2,"Sach",20);
		Student[] students = {student1,student2};

		System.out.println("\nstudents[0]: "+students[0].name);
		
		System.out.println("students[1]: "+students[1].name);
		
		swap(students,0,1);
		System.out.println("\nstudents[0]: "+students[0].name);
		
		System.out.println("students[1]: "+students[1].name);
	
	}
	static void swap(Student[] students, int first, int second){
		Student temp = students[first];
		students[first] = students[second];
		students[second] = temp;
	}
}