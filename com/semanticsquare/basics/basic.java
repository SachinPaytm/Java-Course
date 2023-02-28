package com.semanticsquare.basics;

public class basic {
	static void print() {
		System.out.println("Hello World");
		System.out.print("Hello world without println");
	}

	static void primitives() {
		System.out.println("\n\ninside primitives");
		int intHex = 0x0001;
		System.out.println("intHex: " + intHex);
		int intBinary = 0b010000;
		System.out.println("intBinary: " + intBinary);

		int intChar = 'S';
		System.out.println("intChar: " + intChar);

		char charInt = 83;
		System.out.println("charInt: " + charInt);

	}

	static void typeCasting() {
		System.out.println("\n\ninside typeCasting");
		long y = 1000;
		int x = (int) y;
		System.out.println("int x: " + x);
		byte narrowdByte = (byte) 12346;
		System.out.println("narrowdByte: " + narrowdByte);

		int iTruncated = (int) 0.99;
		System.out.println("iTruncated: " + iTruncated);

		// int to long
		y = x;
	}

	static int count = 20;

	static void arrays() {

		// Student[] students = new Student[3];
		// students[0] = new Student();
		// students[1] = new Student();

		// System.out.println("Student 1: "+students[0]);
		// System.out.println("Student 2: "+students[1]);
		// System.out.println("Student 3: "+students[2]);

	}

	public static void varargs(boolean h, int... list) {
		System.out.println("list.length: " + list.length);
	}

	static double sum(double x, double y) {
		double sum = x + y;
		return sum;
	}

	static double avg(double x, double y) {
		double avg = sum(x, y) / 2;
		return avg;
	}

	static boolean search(int[] are, int key) {
		return true;
	}

	static void labeled() {
		outerBreak: for (int i = 0; i < 10; i++) {

			for (int j = 0; j < 10; j++) {
				if (i == 5 && j == 0) {
					break outerBreak;
				}

			}
		}

		outerContinue:

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (i == 5 && j == 0) {
					continue outerContinue;
				}
			}
		}
	}

	static void rec(int I) {
		if (I < 0) {
			return;
		}
		System.out.println("num: " + I);
		rec(I - 1);
	}

	public void foo() {
		System.out.println("Inside public method of class basic");
	}

	protected void fo() {
		System.out.println("Inside protected method of class basic");
	}

	static void strings() {
		String s = "Hello" + " World!";
		System.out.println(s);
		System.out.println("s.equalIgnoreCase: " + s.equalsIgnoreCase("HELLO world!"));
		System.out.println("s.search: " + s.contains("HELLO world!"));
		System.out.println("s.substring: " + s.substring(4));

		StringBuffer sb = new StringBuffer();
		sb.append("Good").append(" Bye");
		System.out.println("sb: " + sb);

		sb.delete(4, 5);
		System.out.println("sb: " + sb);

		sb.insert(4, " H ");
		System.out.println("sb: " + sb);

		StringBuilder sbl = new StringBuilder();
		sbl.append("we are string builder");
		System.out.println("sbl: " + sbl);
		String sbls = sbl.toString();
		System.out.println("sbl toString(): " + sbls);

		// use StringBuilder rather than + for concatenation

	}

	static final int MON = 2;
	static {
		System.out.println("Inside static initialization 					");
		// MON = 2;
	}

	static void finalVariable() {
		final int MON = 2;
		switch (3) {
		case 1:
			break;
		case MON:
			break;
		case 3:
			break;
		default:
			break;
		}

	}

	static void boxedPrimitives() {
		Integer bint = Integer.valueOf(8);
		Character nchar = Character.valueOf('c');
		Boolean bbool = Boolean.valueOf(true);
		System.out.println(bint);
		System.out.println(nchar);
		System.out.println(bbool);

		String s = "430 The name sachin";
		String[] items = s.split(" ");
		long id = Long.parseLong(items[0]);
		System.out.println(id);

		char c = items[3].charAt(0);
		System.out.println(c);
	}

	public static void main(String[] args) {
		// print();
		// primitives();
		// typeCasting();
		// arrays();
		// System.out.println(sum(2,3));
		// System.out.println(avg(2,3));
		// varargs(true , new int[]{12,343,45});
		// int[] arr = new int[]{1,2,3};
		// System.out.println(search(arr,2));
		// labeled();
		// rec(5);
		// strings();
		// finalVariable();
		boxedPrimitives();

	}
}
