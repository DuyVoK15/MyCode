/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class FoodManager implements Function {

    ArrayList<Food> listFood;

    public FoodManager() {
        listFood = new ArrayList<Food>();
    }

    public FoodManager(ArrayList<Food> listFood) {
        this.listFood = listFood;
    }

    public ArrayList<Food> getListFood() {
        return listFood;
    }

    public void setListFood(ArrayList<Food> listFood) {
        this.listFood = listFood;
    }

    public String checkIdIsExist() {
        String s;
        boolean check = true;
        do {
            try {
                do {
                    s = CheckInput.checkID();
                    for (Food f : listFood) {
                        if (f.getID().equals(s)) {
                            check = true;
                            throw new Exception();
                        }
                        check = false;
                    }
                } while (check == true);

                return s;
            } catch (Exception e) {
                System.out.println("-----ID is exist!-----");
                System.out.println(" -----Try again!-----");
            }
        } while (true);
    }

    public void readFromFile() {
        try {
            FileReader fr = new FileReader("FoodData.txt");
            BufferedReader bf = new BufferedReader(fr);
            String line = "";

            while (true) {
                line = bf.readLine();
                if (line == null) {
                    break;
                }
                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String txt[] = line.split(",");
                String ID = txt[0];
                String name = txt[1];
                double weight = Double.parseDouble(txt[2]);
                String type = txt[3];
                String place = txt[4];
                Date expiredDate = df.parse(txt[5]);

                Food f = new Food(ID, name, weight, type, place, expiredDate);

                listFood.add(f);
            }
            bf.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("**Read data successful! Below is the list of food taken: ");
        for (Food f : listFood) {
            System.out.println(f);
        }
    }

    public void saveToFile(ArrayList<Food> listFood) {
        try {
            System.out.println("Enter your file name (<<file_name>>.dat): ");
            String filename = CheckInput.checkFormatFile();

            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            for (Food f : listFood) {
                oos.writeObject(f.toString());
            }

            oos.close();
            fos.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void readFile() {
        Object obj = null;
        try {
            System.out.println("Enter your file name to read (<<file_name>>.dat): ");
            String filename = CheckInput.checkFormatFile();

            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);

            System.out.println("**Read all information from file!");
            while (fis.available() > 0) {
                obj = ois.readObject();
                System.out.println(obj);
            }
            ois.close();
            fis.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void create() {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        boolean check = true;

        do {
            try {

                System.out.print("Enter ID food(XX****): ");
                String ID = checkIdIsExist();
                System.out.print("Enter name of food: ");
                String name = CheckInput.checkString();
                System.out.print("Enter weight of food: ");
                double weight = CheckInput.checkDouble();
                System.out.print("Enter type of food: ");
                String type = CheckInput.checkString();
                System.out.print("Enter place of food(Cooler/Freezer): ");
                String place = CheckInput.checkPlace();
                System.out.print("Enter expired date of food(dd/MM/yyyy): ");
                Date date = df.parse(sc.nextLine());

                Food f = new Food(ID, name, weight, type, place, date);

                listFood.add(f);
                System.out.println("**This food is added!");
                System.out.println("**Do you want to continue adding another new food? Y/N?");
                System.out.println("** Y to continue, N to return menu");
                String answer = CheckInput.checkYesNo();
                if (answer.equals("Y")) {
                    check = true;
                } else {
                    check = false;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (check == true);
    }

    @Override
    public void search() {

        boolean check = true;
        do {
            System.out.print("**Enter name of food to search: ");
            String _name = CheckInput.checkString();
            boolean c = false;
            for (Food f : listFood) {
                if (f.getName().contains(_name)) {
                    System.out.println(f);
                    c = true;
                }
            }
            if (c == false) {
                System.out.println("This food does not exist!");
            }

            System.out.println("**Do you want to continue searching another new food? Y/N?");
            System.out.println("** Y to continue, N to return menu");
            String answer = CheckInput.checkYesNo();
            if (answer.equals("Y")) {
                check = true;
            } else {
                check = false;
            }
        } while (check == true);
    }

    @Override
    public void remove() {

        System.out.print("**Enter ID food to remove(XX****): ");
        String _ID = CheckInput.checkID();
        boolean c = false;
        for (int index = 0; index < listFood.size(); index++) {
            if (listFood.get(index).getID().equals(_ID)) {
                c = true;
                System.out.println("**Do you want to remove this food? Y/N?");
                System.out.println("** Y to Yes, N to No");
                String answer = CheckInput.checkYesNo();
                if (answer.equals("Y")) {
                    listFood.remove(index);
                    System.out.format("**Success! ID %s is removed!\n", _ID);
                } else if (answer.equals("N")) {
                    System.out.format("**Fail! ID %s is not removed!\n", _ID);
                }
            }
        }

        if (c == false) {
            System.out.println("This food does not exist!");
        }
    }

    static LocalDate getDate(String s) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(s, formatter);
        return date;
    }

    @Override
    public void sortByDate() {

        Comparator<Food> compareExpiredDate = new Comparator<Food>() {
            @Override
            public int compare(Food f1, Food f2) {
                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

                try {
                    String strExpireDate1 = df.format(f1.getExpiredDate());
                    String strExpireDate2 = df.format(f2.getExpiredDate());

                    LocalDate d1 = getDate(strExpireDate1);
                    LocalDate d2 = getDate(strExpireDate2);

                    return d1.compareTo(d2);
                } catch (Exception e) {
                    return 0;
                }
            }
        };
        System.out.println("Sort by Expired Date: ");
        Collections.sort(listFood, compareExpiredDate);
        for (Food f : listFood) {
            System.out.println(f);
        }
    }

    public void saveFile() {
        saveToFile(listFood);
        System.out.println("**Saved all information to file!");
        readFile();

    }

}
