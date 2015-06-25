package com.averis;

public class Oopex2_Loan {
	//one method three arguments
	int calcLoanPayment(int amount, int numberOfMonths){
		//default for single state (prog assumes is for spec state)
		return amount;
		
		//if state given... can just call overloaded method here... keep BL in one place
		//calcLoanPayment(amount, numberOfMonths, "NY");
		
	}
	
	int calcLoanPayment(int amount, int numberOfMonths, String state){
		
		return amount;
	}
}
