package Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import com.averis.predicate.Wine;

public class StreamDemo {
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
			
			
			//start lazy streams demo: Demo2
			Stream<Wine> americanWin = bottles.stream() 											//Turn into a stream
							.filter(brrss -> { System.out.println("Inside Filter " + brrss.country);
												return "USA".equals(brrss.country);					//Intermediate operation filter
											}); 	

					
			System.out.println("================================================");//end lazy streams demo2
			
			
			//start lazy stream demo 3
			DoubleStream americanWinePrices = (americanWin)
					.mapToDouble(brrr -> { System.out.println("Inside MapToDouble: " //map = similar to select column list in SQL e.g. col1 contain=3 -> col2 to contain=1
							+ brrr.name + ": " + brrr.price);
							return brrr.price;
					});
			
			
			//System.out.println("The avg American wine price is $" + americanWinePrices.average().getAsDouble());
			
			System.out.println("_______________________________________________");//end demo 3
			
			//start lazy stream demo 4
			List<Wine> americanWi = new ArrayList<>();
			
			americanWi = bottles.parallelStream()
					.filter(brr -> "USA".equals(brr.country)) // filter = similar to "where" statement in SQL & reduce() => aggregates data similar to select count(*) or select sum(price) in SQL
					.collect(Collectors.toList());
					
			americanWi.forEach(System.out::println);		
			
			//end demo 4
			
		}
	
	
}
