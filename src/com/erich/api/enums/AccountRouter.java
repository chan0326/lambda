package com.erich.api.enums;

import com.erich.api.account.Accountcontroller;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum AccountRouter {
    EXIT("0",i->{
        return false;
    }),
    Creat("1",i->{
        System.out.println("Exit");
        return true;}),
    Deposit("2",i->{
        System.out.println("1-Creat");
        System.out.println(Accountcontroller.getinstance().createAccount(i));
        return true;}),
    Withdraw("3",i->{
        System.out.println("2-Deposit");
        System.out.println(Accountcontroller.getinstance().deposit(i));
        return true;}),
    Balance("4",i->{
        System.out.println("4-Balance");
        System.out.println(Accountcontroller.getinstance().getBalance(i));
        return true;}),
    RemoveAccount("5",i->{
        System.out.println("5-RemoveAccount");
        System.out.println(Accountcontroller.getinstance().deletAcoount(i));
        return true;}),
    AccountList("6",i->{
        System.out.println("6-AccountList");
        System.out.println(Accountcontroller.getinstance().getAccount());
        return true;})
    ;
    private final String input;

    private final Predicate<Scanner>predicate;

    AccountRouter(String input, Predicate<Scanner> predicate) {
        this.input = input;
        this.predicate = predicate;
    }

    public static Boolean execute(Scanner sc) {
        System.out.println("[사용자메뉴]\n" +
                "0-Exit\n " +
                "1-Creat\n " +
                "2-Deposit\n " +
                "3-Withdraw\n " +
                "4-Balance\n"+
                "5-RemoveAccount\n"+
                "6-AccountList\n"
        );
        String foo = sc.next();
        return Stream.of(values())
                .filter(i->i.input.equals(foo))
                .findAny().orElseGet(()->EXIT).predicate.test(sc);
    }
}
