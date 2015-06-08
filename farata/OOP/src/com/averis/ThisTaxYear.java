package com.averis;

public class ThisTaxYear {

	public static void main (String[] args){
		double grossIncome; // local variables
		String state;
		int dependents;
		
		/*if (args.length != 3){
			System.out.println("Sample usage of the program:" +
			" java TestTax 65000 MA 2");
			System.exit(0);
			}*/
		
		//double grossIncome = Double.parseDouble(args[0]);
		//String state = args[1];
		//int dependents = Integer.parseInt(args[2]);
		//example strings at command line... 
		
		//.getTaxOptimiser() is supposed to create instance of inner class:
		//Tax t = new Tax(50000,"NJ", 2);
		
		
		grossIncome= 60000;
		dependents= 2;
		state= "AZ";
		
		StateSpecificTax nj = new StateSpecificTax(grossIncome, state, dependents);
		//Tax t = new Tax(50000, "NJ", 2);
		
		//Tax TaxOptimizer tOptimizer = t.getTaxOptimizer();
		//Tax TaxOptimizer tOptimizer = t.new TaxOptimizer();
		//tOptimizer.setTaxCode(12345);
		
		double yourTax = nj.calcTax();
		double totalTax = nj.adjustForStudents(yourTax);
		double inEuro = nj.convertToEuro(totalTax);
				
		//print the result
		System.out.println("Total tax is " + yourTax + " Student rate is " + totalTax);
		System.out.println("Total Tax in Euros is " + inEuro);
	}
}
