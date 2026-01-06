package com.bank.main;

import java.util.Scanner;
import com.bank.dao.BankDAO;

public class BankApp {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BankDAO dao = new BankDAO();

        while (true) {
            System.out.println("\n1.Create Account\n2.Deposit\n3.Withdraw\n4.Check Balance\n5.Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Account No: ");
                    int acc = sc.nextInt();
                    System.out.print("Name: ");
                    String name = sc.next();
                    System.out.print("Initial Balance: ");
                    double bal = sc.nextDouble();
                    dao.createAccount(acc, name, bal);
                    System.out.println("Account Created");
                    break;

                case 2:
                    System.out.print("Account No: ");
                    dao.deposit(sc.nextInt(), sc.nextDouble());
                    System.out.println("Amount Deposited");
                    break;

                case 3:
                    System.out.print("Account No: ");
                    dao.withdraw(sc.nextInt(), sc.nextDouble());
                    System.out.println("Amount Withdrawn");
                    break;

                case 4:
                    System.out.print("Account No: ");
                    System.out.println("Balance: " + dao.getBalance(sc.nextInt()));
                    break;

                case 5:
                    System.exit(0);
            }
        }
    }
}
