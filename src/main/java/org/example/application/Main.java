package org.example.application;

import org.example.model.entities.Account;
import org.example.model.exceptions.DomainException;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Account acc1 = new Account();

        try {
            System.out.println("Enter with account data:");
            System.out.print("Number: ");
            acc1.setNumber(sc.nextLine());
            System.out.print("Holder: ");
            acc1.setHolder(sc.nextLine());
            System.out.print("Balance: ");
            acc1.deposit(sc.nextDouble());
            System.out.print("Withdraw limit: ");
            acc1.setWithdrawLimit(sc.nextDouble());

            System.out.println();
            System.out.println(acc1);

            System.out.print("Enter amount for withdraw: ");
            acc1.withdraw(sc.nextDouble());


        } catch (DomainException e) {
            System.out.println("Withdraw error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Balances and withdraws only accepts numbers.");
        }

    }
}