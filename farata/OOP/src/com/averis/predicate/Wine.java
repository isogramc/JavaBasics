package com.averis.predicate;

public class Wine {
		    public String name;
		    public String country;
		    public float price;
		
		    public Wine(String name, String country,float price){
		        this.name=name;
		        this.country=country;
		        this.price=price;
		    }
	
		    public String toString(){
		        return "Country: " + country +  "; Name: " + name + "; Price: " + price;
		    }
}
