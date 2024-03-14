package com.erich.api.strategy;

import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public enum WeekendStrategy {
    Mon("1",i->"월"),
    Tuse("2",i->"화"),
    Wed("3",i->"수"),
    Thur("4",i->"목"),
    Fir("5",i->"금"),
    Sat("6",i->"토"),
    Sun("7",i->"일"),
    Err("x",i->"Err")
    ;

    private final String name;

    private final Function<String,String>function;

    WeekendStrategy(String name, Function<String, String> function) {
        this.name = name;
        this.function = function;
    }

    public static String execute(Scanner sc) {
        System.out.println("1~7입력");
        String foo = sc.next();
        return Stream.of(values()).filter(i->i.name.equals(foo))
                .findAny().orElseGet(()->Err).function.apply(foo);
    }
}
