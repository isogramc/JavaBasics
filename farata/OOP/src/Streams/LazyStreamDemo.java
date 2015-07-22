package Streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import com.averis.predicate.Wine;

public class LazyStreamDemo {
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
			
			//Filter map reduce with chaining
			//this is a simple lazy streams demo: Demo1
			List<Wine> americanWine = new ArrayList<>();
			
			americanWine = bottles.stream() 				//Turn into a stream
					.filter(brr -> brr.country == "USA") 	//Intermediate operation filter
					.collect(Collectors.toList());			//Terminal operation: create a new collection
			
			americanWine.forEach(ambr -> System.out.println("American Wine " +ambr.name));
			
			System.out.println("================================================");//end lazy streams demo1
			
			
			//start streams api demo: Sorting the stream
			System.out.println("\nSorting beers by price");
			bottles.parallelStream() 											//Turn into a stream
							.sorted(Comparator.comparing(b -> b.price))
							.forEachOrdered(System.out::println); 	

					
			System.out.println("================================================");//end lazy streams demo2
			
			
			//start stream api demo 3
			//apply filter, map, reduce (average)
			OptionalDouble averagePrice = bottles.stream()
					.filter(brr -> brr.country=="USA")
					.mapToDouble(brrr -> brrr.price)
					.average();
					
			System.out.printf("The avg American wine price is $%3.2f", averagePrice.getAsDouble());
			
			System.out.println();
			
			System.out.println("_______________________________________________");//end demo 3
			
			//start stream api demo 4
			//Reusing Lambdas with predicate (applied filter with predicate)
			
			Predicate<Wine> madeInUSA = brr-> "USA".equals(brr.country);
			
			americanWine = bottles.parallelStream()
					.filter(madeInUSA).collect(Collectors.toList());
					
			americanWine.forEach(System.out::println);
			
			System.out.println();
			
			System.out.println("_______________________________________________");//end demo 4
			
			//Start Demo5
			Predicate<Wine> cheap = wien -> wien.price < 17.00f;
			
			//Combo of madeInUSA & cheap predicates
			System.out.println("These are cheap American Wines:");
			
			bottles.stream().filter(madeInUSA.and(cheap))
			.forEach(System.out::println);	
			
			System.out.println();
			
			System.out.println("_______________________________________________");//end demo 5
			
			//Demo6
			//filtering using a method reference
			bottles.stream().filter(LazyStreamDemo::isMadeInUSA)
			.forEach(System.out::println);
		}
		
		public static boolean isMadeInUSA(Wine w){
			return w.country=="USA";
		}
	
	
}
