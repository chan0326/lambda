package com.erich.api.account;



import com.erich.api.enums.AccountRouter;

import java.sql.SQLException;
import java.util.Scanner;

public class AccountView {
static  Accountcontroller accountcontroller = Accountcontroller.getinstance();
    public static void main(Scanner sc) throws SQLException {
        while (AccountRouter.execute(sc));
//        execute(sc);

    }
}

//    private static void execute(Scanner sc) {
//        while(true) {
//            System.out.println("[사용자메뉴]\n" +
//                    "0-Exit\n " +
//                    "1-Creat\n " +
//                    "2-Deposit\n " +
//                    "3-Withdraw\n " +
//                    "4-Balance\n"+
//                    "5-RemoveAccount\n"+
//                    "6-AccountList\n"
//                    );
//            switch (sc.next()){
//                case "0":
//                    System.out.println("Exit");
//                    return;
//                case "1":
//                    System.out.println("1-Creat");
//                    System.out.println(accountcontroller.createAccount(sc));
//                    break;
//                case "2":
//                    System.out.println("2-Deposit");
//                    System.out.println(accountcontroller.deposit(sc));
//                    break;
//                case "3":
//                    System.out.println("3-Withdraw");
//                    System.out.println(accountcontroller.withdraw(sc));
//                    break;
//                case "4":
//                    System.out.println("4-Balance");
//                    System.out.println(accountcontroller.getBalance(sc));
//                    break;
//                case "5":
//                    System.out.println("5-RemoveAccount");
//                    System.out.println(accountcontroller.deletAcoount(sc));
//                    break;
//                case "6":
//                    System.out.println("6-AccountList");
//                    System.out.println(accountcontroller.getAccount());
//                    break;
//
//            }
//        }
//    }
//}
