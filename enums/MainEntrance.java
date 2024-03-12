package com.erich.api.enums;

import com.erich.api.Main;
import com.erich.api.board.BoardView;

import java.util.Arrays;

import java.util.function.Function;
import java.util.function.Predicate;
 enum MainEntrance {
    EXIT("x",i->i),
    BOARD("b",i->{BoardView.main();
    return "";}),
    USER("u",i->i),
    ACCOUNT("m",i->i),
    CRAWLER("c",i->i),
    ARTICLE("a",i->i);
    private final String input;

    private final Function<String,String>function;



    MainEntrance(String input, Function<String, String> function) {
        this.input = input;

        this.function = function;
    }

    public static String Getname(String input) {
        return "";
    }
    static MainEntrance GetEnum (String a){
        return Arrays.stream(values()).filter(i -> i.input.equals(a)).findFirst().orElseThrow(() -> new IllegalArgumentException("올바른 값이 아닙니다."));
    }



}


