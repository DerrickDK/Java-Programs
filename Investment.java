

import java.util.*;
//This program asks the user for their bank account balance and determines the interest rate the individual wants to invest for a certain amount of time. 
public class Investment {
	private String name; 
	private double Balance;
	private double interest; 
	private double numTime; 
	private int time; 
	

	public Investment(double myBalance, String myName) {
		Balance = myBalance;
		name = myName;
	
	}
	public double getBalance(){
		return Balance;
	}
	public String getName(){
		return name; 
	}
	public void determineBalance(){
		if(Balance >= 1000) {
			Scanner myInput = new Scanner(System.in);
			System.out.println("Determine your interest rate: ");
			double myInterest = myInput.nextDouble();
			myInterest = myInterest/100;
			System.out.println("Determine how many times you want to compound interest with respect to time: ");
			double mynumTime = myInput.nextDouble();
			System.out.println("Determine how long do you want to invest: ");
			int myTime = myInput.nextInt(); 
			interest = myInterest;
			numTime = mynumTime;
			time = myTime;
			double newBalance = Math.pow((Balance*(1+(interest/numTime))),numTime*time);
			newBalance = newBalance/1000;
			System.out.println("My new balance is $"+newBalance);
		} else {
			System.out.println("Sorry, you don't have the required funds to invest yet");	
		}
	}
	

	public static void main(String[] args) {
		Scanner myInput = new Scanner(System.in);
		System.out.println("What is your name?");
		String myName = myInput.nextLine();
		System.out.println("What is your bank balance?");
		double myBalance = myInput.nextDouble();
		Investment user = new Investment(myBalance, myName);
		user.determineBalance();
	

	}

}
