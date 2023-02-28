package Assignments;

class MoneyTransferService{
	public static void main(String[] args){
		CurrencyConverter2 cc = new CurrencyConverter2();
		int cur = 1000;//dollars
		int totalMoney = cc.currency[1]*cur;
		System.out.println("Total Money: "+ totalMoney); //money in rupee
	}	
}