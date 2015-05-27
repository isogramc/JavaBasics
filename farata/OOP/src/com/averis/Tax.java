package com.averis;

public class Tax {
	//this class has three fields/variables and one method
	double grossIncome;
	String state;
	int dependents;
	int customerCounter;
	
	public double calcTax(){
		//return the result of the calculation as a double precision value
				//return 234.90;
				
		double temp;
			
			if(grossIncome <= 50000){
				temp = (grossIncome * 6)/100;
				return temp;
			} else{
				temp = (grossIncome * 8)/100;
				return temp;
			}
			
		}
	
	public double convertToEuro(double dollar){
		return (dollar * 1.25);
		
	}
	
	
	//Constructors
	Tax(){
		grossIncome = 0; //class variable initialization
		state = "";
		dependents = 0;
		customerCounter = 1;
		System.out.println("Preparing the tax data for customer #" + customerCounter);
	}
	
	
	Tax(double gi, String st, int depen){
		grossIncome = gi; //class variable initialization
		state = st;
		dependents = depen;
		System.out.println("Preparing the tax data for customer #" + customerCounter);
	}
}
