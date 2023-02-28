package Assignments;

class CurrencyConverter2{
	/*
	int rupee = 1;
	int dollar = 80;
	int euro = 100;
	*/
	int[] currency = {1,80,100};	
	void print(){
		System.out.println("Rupee's value is: " + currency[0]);
		System.out.println("Dollar's value is: " +  currency[1]);
		System.out.println("Euro's values is: " + currency[2]);
	}		
	public static void main(String[] args){
		CurrencyConverter2 cc = new CurrencyConverter2();
		cc.print();
	}
}
