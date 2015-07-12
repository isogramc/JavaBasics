package com.averis.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FiltersAtWineMethodRef {

	// Populate Wine collection
	static List<Wine> loadCellar() {
		List<Wine> wineStock = new ArrayList<>();

		wineStock.add(new Wine("Chianti", "Italy", 17.75f));
		wineStock.add(new Wine("Champagne", "France", 17.00f));
		wineStock.add(new Wine("Merlot", "USA", 14.00f));
		wineStock.add(new Wine("Cabernet", "RSA", 15.00f));
		wineStock.add(new Wine("Late Harvest", "RSA", 15.50f));
		wineStock.add(new Wine("Riesling", "Belgium", 18.75f));
		wineStock.add(new Wine("Rose", "France", 110.00f));
		wineStock.add(new Wine("Chardonnay", "USA", 18.25f));

		return wineStock;
	}

	public static void main(String[] args) {

		List<Wine> bottles = loadCellar(); // populate the Wine collection
		
		List<Wine> filteredBottles = new ArrayList<>();
		
		// Functional thinking with Predicate, lambda implementation
		// boolean test(T t)

		findWineByCountry(bottles, filteredBottles, "RSA");

		//using predicates alone
		//Predicate<Wine> fromFrance = brr -> "France".equals(brr.country);
		//Predicate<Wine> expensive = brr -> brr.price > 18.00f;
		//Predicate<Wine> expensiveFrance = fromFrance.and(expensive);
		
		//filterWineCollection(bottles, filteredBottles, fromFrance);
		//filterWineCollection(bottles, filteredBottles, expensive);
		//filterWineCollection(bottles, filteredBottles, expensiveFrance);

		//passing function to method as arg
		System.out.println("=============Filter on Wine Collection : show all wine from France============");
		filterWineCollection(bottles, filteredBottles, FiltersAtWineMethodRef::fromFrance);
		System.out.println("=============Filter on Wine Collection : show all wine marked above 18.00f=========");
		filterWineCollection(bottles, filteredBottles, FiltersAtWineMethodRef::isExpensive);
		
	}
	
	
	//functions to be passed through our filter
	private static boolean fromFrance(Wine wine){
		
		return "France".equals(wine.country);
	}
	
	private static boolean isExpensive(Wine wine){
		
		return wine.price > 18.00f;
	}
	
	
	
	private static void findWineByCountry(List<Wine> bottles,
			List<Wine> filteredBottles, String Country) {
		
		//yay (Java8 Champ):
		//bottles.forEach(System.out::println);
		//System.out.println("++++++++++++++++++++++++");
		
		for (Wine wine : bottles) {
			if ("RSA".equals(wine.country)) {
				filteredBottles.add(wine);
				
				System.out.println("In findWineByCountry Wine of origin "
						+ wine.country + ": " + wine.name);
			}
		}
	}

	// two predicate
	private static void filterWineCollection(List<Wine> bottles, List<Wine> filteredBottles, Predicate<Wine> condition) {
		for (Wine wine : bottles) {
			if (condition.test(wine)) {
				filteredBottles.add(wine);


				// If the predicate is French and expensive wine:
				//System.out
				//		.println("In filterWineCollection (got Expensive (>18.00f) French Wine at "
				//				+ wine.price + " : " + wine.name);

			
				System.out.println("In filterWineCollection: Name: "+ wine.name + "; From: " + wine.country + "; Costs: " + wine.price);
				
			}
		}

	}

}
