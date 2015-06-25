package com.averis;

public class Oopex2_Tax {
	//this class has three fields/variables and one method
	double grossIncome;
	protected String state;
	int dependents;
	private int customerCounter;
	
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
	Oopex2_Tax(){
		grossIncome = 0; //class variable initialization
		state = "";
		dependents = 0;
		customerCounter++;
		System.out.println("Preparing the tax data for customer #" + customerCounter);
	}
	
	
	Oopex2_Tax(double gi, String st, int depen){
		grossIncome = gi; //class variable initialization
		state = st;
		dependents = depen;
		customerCounter++;
		System.out.println("Preparing the tax data for customer #" + customerCounter);
	}
}
