/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.CheckInput;
import DTO.FoodManager;
import java.text.ParseException;

/**
 *
 * @author ASUS
 */
public class FoodManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        FoodManager FoodStore = new FoodManager();

        System.out.println("**Welcome to Food Management - @ 2021 by SE150730 - Vo Thanh Duy");
        FoodStore.readFromFile();

        int userChoice;
        do {
            
            System.out.println("**Select the options below: ");
            System.out.println("1. Add a new food. ");
            System.out.println("2. Search a food by name. ");
            System.out.println("3. Remove the food by ID. ");
            System.out.println("4. Print the food list in the descending order of expired date. ");
            System.out.println("5. Save all information to file.");
            System.out.println("6. Quit. ");
            System.out.println("-----------------------------------------------------------------");
            System.out.print("**Please choose: ");

            userChoice = CheckInput.checkInt();

            switch (userChoice) {
                case 1:
                    FoodStore.create();
                    break;
                case 2:
                    FoodStore.search();
                    break;
                case 3:
                    FoodStore.remove();
                    break;
                case 4:
                    FoodStore.sortByDate();
                    break;
                case 5:
                    FoodStore.saveFile();
                    break;
                default:
                    System.out.println("**Good bye. Have a nice day!");
            }
        } while (userChoice > 0 && userChoice < 6);
    }

}
