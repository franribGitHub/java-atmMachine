/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.machine;

/**
 *
 * @author mlarrubia
 */

import java.util.Scanner;

public class ATMMachine {

    /**
     * @param args the command line arguments
     */
    
    private static Scanner kb = new Scanner(System.in);
    
    private static final String Username = "user";
    private static final String Password = "1234";
    private static int balance = 10000;
    
    public static void main(String[] args) {
        System.out.print("Enter Username: ");
        String enteredUsername = kb.nextLine();
        System.out.print("Enter Password: ");
        String enteredPassword = kb.nextLine();
        if (enteredUsername.equals(Username) && enteredPassword.equals(Password)) {
            menu();
        } else {
            System.out.println("\nYour account has been temporarily locked.");
        }
    }
    
    public static void menu() {
        System.out.println("\n1. Check Account Balance");
        System.out.println("2. Deposit Checks");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Logout");
        System.out.print("\nEnter a number 1-4 to select: ");
        int choice = kb.nextInt();
        if (choice == 1) {
            checkBalance();
        } else if (choice == 2) {
            deposit();
        } else if (choice == 3) {
            withdraw();
        } else {
            System.out.println("\nLogged Out.");
        }
    }
    
    public static void checkBalance() {
        System.out.println("\nAccount Balance is $" + balance);
        menu();
    }
    
    public static void deposit() {
        System.out.print("\nHow many checks will be deposited: ");
        int checks = kb.nextInt();
        for (int i = 1; i <= checks; i++) {
            System.out.print("How much is check #" + i + ": ");
            balance += kb.nextInt();
        }
        menu();
    }
    
    public static void withdraw() {
        System.out.print("\nHow much money will be withdrawn: ");
        int withdraw = kb.nextInt();
        if (withdraw > balance) {
            System.out.print("Insufficient Funds.");
        } else {
            balance -= withdraw;
        }
        menu();
    }
    
}
