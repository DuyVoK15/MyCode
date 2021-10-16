/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class CheckInput {

    private static Scanner sc = new Scanner(System.in);

    public static int checkInt() {
        int n;

        do {
            try {
                n = Integer.parseInt(sc.nextLine());
                if (n <= 0) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println("----- Input only positive number! -----");
                System.out.println("         ----- Try again! -----");
            }
        } while (true);
    }

    public static double checkDouble() {
        double d;

        do {
            try {
                d = Double.parseDouble(sc.nextLine());
                if (d <= 0) {
                    throw new Exception();
                }
                return d;
            } catch (Exception e) {
                System.out.println("----- Input only positive number! -----");
                System.out.println("        ----- Try again! -----");
            }
        } while (true);
    }

    public static String checkString() {
        String s;

        while (true) {
            s = sc.nextLine().trim();
            if (s == null || s.equals("")) {
                System.out.println("----- Error! You must insert data! -----");
            } else {
                return s;
            }
        }
    }

    public static String checkID() {
        String id;

        while (true) {
            id = sc.nextLine().trim();
            if (!id.matches("^[A-Z]{2}\\d{4}$")) {
                System.out.println("----- Error! You must insert XX****(X is Upper case [A-Z], * is number [0-9]! -----");
            } else {
                return id;
            }
        }

    }
    
    public static String checkPlace() {
        String pl;

        while (true) {
            pl = sc.nextLine().trim();

            if (!pl.matches("Cooler") && !pl.matches("Freezer")) {
                System.out.println("----- Error! You must insert Cooler/Freezer!  -----");
            } else {
                return pl;
            }
        }
    }
    
    public static String checkYesNo() {
        String yN;

        while (true) {
            yN = sc.nextLine().trim();
            if (!yN.matches("^[Y,N]$")) {
                System.out.println("----- Error! You must insert Y/N! -----");
            } else {
                return yN;
            }
        }
    }

    public static String checkFormatFile() {
        String fm;

        while (true) {
            fm = sc.nextLine().trim();

            if (!fm.matches("^[A-Za-z0-9!#$%&'*+=^_`{}~-]{0,16}+[.]{1}+[d]{1}+[a]{1}+[t]{1}$")) {
                System.out.println("----- The folder name is in the wrong format!  -----");
            } else {
                return fm;
            }
        }
    }
}
