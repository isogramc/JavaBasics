package com.averis;

public class ThisTaxYear {

	public static void main (String[] args){
		double grossIncome; // local variables
		String state;
		int dependents;
		
		grossIncome= 60000;
		dependents= 2;
		state= "AZ";
		
		StateSpecificTax nj = new StateSpecificTax(grossIncome, state, dependents);
		
		double yourTax = nj.calcTax();
		double totalTax = nj.adjustForStudents(yourTax);
		double inEuro = nj.convertToEuro(totalTax);
				
		//print the result
		System.out.println("Total tax is " + yourTax + " Student rate is " + totalTax);
		System.out.println("Total Tax in Euros is " + inEuro);
	}
}
