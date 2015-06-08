package com.averis;

public class StateSpecificTax extends Tax{

	public double calcTax(){
		//this method overrides calcTax in Tax(bass) class
		double temp;
			if(grossIncome <= 50000){
				temp = (grossIncome * 10)/100;
				return temp;
			} else{
				temp = (grossIncome * 13)/100;
				return temp;
			}	
		}
	
	double adjustForStudents(double stateTax){
		double adjustedTax = stateTax - 500;
		return adjustedTax;
	}
	
	
	StateSpecificTax(double gi, String st, int depen) {
		super(gi, st, depen);
		// TODO Auto-generated constructor stub
	}
	
	class TaxOptimizer {
		int taxCode;
		
		void setTaxCode (int tCode){
			taxCode = tCode;
		}
		
		int optimise(double grossIncome, int dep){
			//some optimisation code here
			return 0;
		} 
	}
}
