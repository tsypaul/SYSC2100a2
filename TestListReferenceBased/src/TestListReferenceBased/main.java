package TestListReferenceBased;

import java.util.Scanner;

/**
 * Created by shaoyutan on 2017-02-07.
 */
public class main {


    public static void main(String[] args) {
    	TestListReferenceBased l = new TestListReferenceBased();
    	while(true){
	        int choice = -1;
	        // get input
	        while (choice < 0 || choice > 5) {
	        	System.out.println("");
	        	System.out.println("");
	            System.out.println("Choose a performance you want to perform:");
	            System.out.println("1. display the list");
	            System.out.println("2. add a number");
	            System.out.println("3. remove a number");
	            System.out.println("4. get a number");
	            System.out.println("5. removeAll numbers in the list");
	            System.out.println("0. exit");
	            Scanner s = new Scanner(System.in);
	            choice = s.nextInt();
	        }
	        
	        if (choice == 0) {
	        	System.exit(0);
	        }
	        // Check if the list is empty,
	        // if it is empty, we cannot remove item from the list
	        // if it is not empty, we can remove item from the list
	        if (l.isEmpty()) {
	            System.out.println("The list is empty.");
	        } else if (choice == 3) {
	            // remove a number from a specific position
	            System.out.println("Please enter the position you want to remove: (position starts from 0)");
	            Scanner s3 = new Scanner(System.in);
	            int removePosition = s3.nextInt();
	            int removeNumber = l.remove(removePosition);
	            System.out.println("Number " + removeNumber + " is removed from position " + removePosition);
	            l.displayList();
	        }
	        // Display list
	        if (choice == 1) {
	            l.displayList();
	        }
	        // Add a number to a specific position in the list
	        if (choice == 2) {
	            System.out.println("Please enter the number you want to add:");
	            Scanner s1 = new Scanner(System.in);
	            int addNumber = s1.nextInt();
	            System.out.println("Please enter a position you want to add the number to:");
	            Scanner s2 = new Scanner(System.in);
	            int addPosition = s2.nextInt();
	            l.add(addNumber, addPosition);
	            if(addPosition > l.size-1){
	            	System.out.println("The position you add to is out of the position, please restart program");
	            	break;
	            }
	            System.out.println("Number " + addNumber + " is added at position " + addPosition);
	            l.displayList();
	        }
	        // remove all
	        if (choice == 5) {
	            l.displayList();
	            System.out.print("have been removed.");
	            l.removeAll();
	            l.displayList();
	        }
	        
    	}
    	
    }
}
