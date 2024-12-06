// Written by Darius Washington
public class Apple {

		//Creates Variables
		private String type;
		private double weight;
		private double price;
		
		//Setting Defaults
		public Apple() {
			this.type = "Gala";
			this.weight = 0.0;
			this.price = 0.0;
		}
		
		//Creates apple with values
		public Apple(String type, double weight, double price) {
			setType(type);
			setWeight(weight);
			setPrice(price);
		}
		
		//Accessor
		public String getType() {
			return type;
		}
		
		//Checks for valid values 
		public void setType(String type) {
			if (type == null || 
			    (!type.equals("Red Delicious") &&
			     !type.equals("Golden Delicious") &&
				 !type.equals("Gala") &&
				 !type.equals("Granny Smith"))) {
				this.type = "Gala";
			} else {
				this.type = type;
			}
		}
		
		//Accessor
		public double getWeight() {
			return weight;
		}
		
		//Checks for valid weight 
		public void setWeight(double weight) {
			if (weight < 0.0 || weight > 2.0) {
				this.weight = 0.0;
			} else {
				this.weight = weight;
			}
		}
		
		//Accessor
		public double getPrice() {
			return price;
		}
		
		//Checks for valid price 
		public void setPrice(double price) {
			if (price < 0.0) {
				this.price = 0.0;
			} else {
				this.price = price;
			}
			
		}
			
		//Shows the data for the apple
		public String toString() {
			return "Type: " + type + " Weight: " + weight + " Price: " + price;
		}
		
		//Checks if apples are equal
		public boolean equals(Apple other) {
			if (other == null) {
				return false;
			}
			return this.type.equals(other.type) &&
				   this.weight == other.weight &&
				   this.price == other.price;
		}
		
		
		//Creates Apple Tester
		public class AppleTester{
			public static void main(String[] args) {
				
				//Introduces user to the program
				System.out.println("Welcome to the apple tester");
				
				//Creates an apple with defaults
				Apple apple1 = new Apple();
				System.out.println("Creating a default apple");
				System.out.println("Printing the default apple's value");
				System.out.println(apple1);
				
				//Creates an apple with specific values
				System.out.println("Creating another apple");
				Apple apple2 = new Apple("Granny Smith", 0.75, 0.99);
				System.out.println("Printing and setting the new apple's values to the following valid values");
				System.out.println(apple2);
				
				//Creates an apple with invalid values
				System.out.println("Creating another default apple");
				Apple apple3 = new Apple();
				System.out.println("Then setting the new apple's values to the following invalid values iPad 2.5 -200");
				apple3.setType("iPad");
				apple3.setWeight(2.5);
				apple3.setPrice(-200);
				System.out.println("Printing the newest apple's values which should not have changed from the default values");
				System.out.println(apple3);
				
				//Checks if the default apple and invalid apple are the same
				System.out.println("Checking if the first and last apple have the same values.");
				System.out.println(apple1.equals(apple3));
			}
			
		}


}
