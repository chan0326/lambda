package com.erich.api.account;



import java.util.Scanner;

public class AcoountView {

    public static void main(Scanner sc) {
        Accountcontroller ac = new Accountcontroller();
        while(true) {
            System.out.println("[사용자메뉴]\n" +
                    "0-Exit\n " +
                    "1-Creat\n " +
                    "2-Deposit\n " +
                    "3-Withdraw\n " +
                    "4-Balance\n"+
                    "5-RemoveAccount\n"+
                    "6-AccountList\n"
                    );
            switch (sc.next()){
                case "0":
                    System.out.println("Exit");
                    return;
                case "1":
                    System.out.println("1-Creat");
                    System.out.println(ac.createAccount(sc));
                    break;
                case "2":
                    System.out.println("2-Deposit");
                    System.out.println(ac.deposit(sc));
                    break;
                case "3":
                    System.out.println("3-Withdraw");
                    System.out.println(ac.withdraw(sc));
                    break;
                case "4":
                    System.out.println("4-Balance");
                    System.out.println(ac.getBalance(sc));
                    break;
                case "5":
                    System.out.println("5-RemoveAccount");
                    System.out.println(ac.deletAcoount(sc));
                    break;
                case "6":
                    System.out.println("6-AccountList");
                    System.out.println(ac.getAccount());
                    break;

            }
        }

    }
}
