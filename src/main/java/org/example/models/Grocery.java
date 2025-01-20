package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {
    public static void main(String[] args) {
        startGrocery();
    }
   public static ArrayList<String> groceryList = new ArrayList<>();


   static Scanner groceryScanner = new Scanner(System.in);
   public static void startGrocery() {

       int choice;

       do {
           System.out.println("Welcome, what do you want to do ? \n" +
                   "0 - Close the app, 1 - Add a product, 2 - Remove a product.");
           choice = groceryScanner.nextInt();
           groceryScanner.nextLine();
           switch (choice) {
               case 0:
                   System.out.println("Closing...\n"+"Thank you for using Grocery App, goodbye!");
                   groceryScanner.close();
                   break;
               case 1:
                   System.out.println("Type the products you want to add to the cart. You can separate them by ','");
                   String productsToAdd = groceryScanner.nextLine();
                   addItems(productsToAdd);
                   break;
               case 2:
                   if (groceryList.isEmpty() ) {
                       System.out.println("Your cart is already empty!");
                       break;
                   } else {
                       System.out.println("Type the products you want to remove from the cart. You can separate them by ','");
                       String productsToRemove = groceryScanner.nextLine();
                       removeItems(productsToRemove);
                   }
                   break;
               default:
                   System.out.println("Invalid operation request! Your selection is out of range ( 0 - 2 )");
                   break;
           }

               System.out.println();
       } while (choice != 0);


   }

    public static boolean checkItemIsInList(String item) {
        return groceryList.contains(item);
    }

    public static void printSorted() {
       if (groceryList.isEmpty()) {
           System.out.println("Your cart is empty.");
       } else {
           Collections.sort(groceryList);
           System.out.println("Your current cart is: ");
           for(String product: groceryList) {
               System.out.println("- " +product);
           }
       }
    }

    public static void addItems(String items) {
        String[] splitItems = items.split(",");
        for (String item : splitItems) {
            String trimmed = item.trim();
            if (checkItemIsInList(trimmed)) {
                System.out.println(trimmed + " is already in the cart.");
            } else if (!trimmed.matches("[a-zA-Z\\s]+")) {
                System.out.println("Invalid input!"  + "Please type letters only!");
            }
            else {
                groceryList.add(trimmed);
                System.out.println(trimmed + " added to your cart.");
            }
        }
        printSorted();
   }


    public static void removeItems(String items) {
        String[] splitItems = items.split(",");

        for (String item : splitItems) {
            String trimmed = item.trim();

            if (!checkItemIsInList(trimmed)) {
                System.out.println("Invalid request! " + trimmed + " is not already in the cart.");
            } else {
                groceryList.remove(trimmed);
                System.out.println(trimmed + " removed from your cart.");

            }
        }
        printSorted();
    }


}
