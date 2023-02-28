package Assignments;

class CurrencyConverter1{
	int rupee = 1;
	int dollar = 80;
	int euro = 100;
	
	void print(){
		System.out.println("Rupee's value is: " + rupee);
		System.out.println("Dollar's value is: " +  dollar);
		System.out.println("Euro's values is: " + euro);
	}		
	public static void main(String[] args){
		CurrencyConverter1 cc = new CurrencyConverter1();
		cc.print();
	}
}
