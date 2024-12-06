// Written by Darius Washington

import java.util.Scanner;

public class Homework3 {
	
	// Setting up Rectangle
static class Rectangle {
	double length;
	double width;
	
	//Create the Rectangle
	Rectangle(double length, double width){
		this.length = length;
		this.width = width;
	}
	
	// Calculate the Area
 double getArea() {
	 return length * width;
 		}
	}

 public static void main(String[] args) {
	 Scanner scanner = new Scanner(System.in);
	 Rectangle[] rectangles = null;
	 int size = 0;
	 
	 // Gives options for user and performs operations
	 while (true) {
		 System.out.println("\nRectangle Manager");
		 System.out.println("1. Enter Rectangle Data");
		 System.out.println("2. Sort and Display Rectangles from Smallest to Largest");
		 System.out.println("3. Sort and Display Rectangles from Largest to Smallest");
		 System.out.println("4. Display Average Area");
		 System.out.println("5. Display Minimum Area");
		 System.out.println("6. Display Maximum Area");
		 System.out.println("7. Quit");
		 
		 System.out.print("Choose an option: ");
		 int option = scanner.nextInt();
		 
		 switch (option) {
		 case 1: System.out.print("Enter the number of rectangles: ");
		 		 size = getValidArraySize(scanner);
		 		 rectangles = new Rectangle[size];
		 		 
		 		 for (int i = 0; i < size; i++) {
		 			 System.out.print("Enter length of rectangle " + (i + 1) + ": ");
		 			 double length = scanner.nextDouble();
		 			 System.out.print("Enter width of rectangle " + (i + 1) + ": ");
		 			 double width = scanner.nextDouble();
		 			 rectangles[i] = new Rectangle(length, width);
		 		 }
		 		 break;
		 case 2: 
			 if (rectangles != null && rectangles.length > 0) {
				 sortRectanglesByArea(rectangles, true);
				 displayAreas(rectangles);
			 } else {
				 System.out.println("No rectangles available to sort.");
			 }
			 break;
			 
		 case 3:
			 if (rectangles != null && rectangles.length > 0) {
				 sortRectanglesByArea(rectangles, false);
				 displayAreas(rectangles);
			 } else {
				 System.out.println("No rectangles available to sort.");
			 }
			 break;
			 
		 case 4: 
			 if (rectangles != null && rectangles.length > 0) {
				 double averageArea = calculateAverageArea(rectangles);
				 System.out.println("Average Area: " + averageArea);
			 } else {
				 System.out.println("No rectangles available to calculate average.");
			 }
			 break;
			 
		 case 5: 
			 if (rectangles != null && rectangles.length > 0) {
				 double minArea = findMinimumArea(rectangles);
				 System.out.println("Minimum Area: " + minArea);
				 } else {
					 System.out.println("No rectangles available to find minimum.");
				 }
			 	break;
			 	
		 case 6:
			 if (rectangles != null && rectangles.length > 0) {
				 double maxArea = findMaximumArea(rectangles);
				 System.out.println("Maximum Area: " + maxArea);
			 } else {
				 System.out.println("No rectangles available to find maximum.");
			 }
			 break;
			 
		 case 7: 
			 System.out.println("Exiting program.");
			 return;
			 
		default: 
			System.out.println("Invalid option. Please try again.");
			break;
		 }
	 }
 }
 
 // Get a Valid Array
 public static int getValidArraySize(Scanner scanner) {
	 int size;
	 while (true) {
		 size = scanner.nextInt();
		 if (size > 0) {
			 break;
		 } else {
			 System.out.print("Please enter a valid size (positive number): ");
		 }
	 }
	 return size;
 }
 
  // Sort rectangles by area
 public static void sortRectanglesByArea(Rectangle[] rectangles, boolean ascending) {
	 for (int i = 0; i < rectangles.length - 1; i++) {
		 for (int j = 0; j < rectangles.length - 1 - i; j++) {
			 double area1 = rectangles[j].getArea();
			 double area2= rectangles[j + 1].getArea();
			 
			 if ((ascending && area1 > area2) || (!ascending && area1 < area2)) {
				 Rectangle temp = rectangles[j];
				 rectangles[j]=rectangles[j+1];
				 rectangles[j + 1] = temp;
			 }
		 }
	 }
 }
 
 	// Display areas of Rectangles
 	public static void displayAreas(Rectangle[] rectangles) {
 		System.out.println("Areas of Rectangles:");
 		for (int i = 0; i < rectangles.length; i++) {
 			System.out.println("Rectangle " + (i + 1) + ": " + rectangles[i].getArea());
 			
 		}
 	}
 	
 	//Calculate the average area
 	public static double calculateAverageArea(Rectangle[] rectangles) {
 		double sum = 0;
 		for (Rectangle rectangle : rectangles) {
 			sum += rectangle.getArea();
 		}
 		return sum / rectangles.length;
 	}
 	
 	//Find the minimum area for Rectangle Set
 	public static double findMinimumArea(Rectangle[] rectangles) {
 		double minArea = rectangles[0].getArea();
 		for (Rectangle rectangle : rectangles) {
 			double area = rectangle.getArea();
 			if (area < minArea) {
 				minArea = area;
 			}
 		}
 		return minArea;
 	}
 	
 	// Find the maximum area for Rectangle Set
 	public static double findMaximumArea(Rectangle[] rectangles) {
 		double maxArea = rectangles[0].getArea();
 		for (Rectangle rectangle : rectangles) {
 			double area = rectangle.getArea();
 			if (area > maxArea) {
 				maxArea = area;
 			}
 		}
 		return maxArea;
 	}
 
}