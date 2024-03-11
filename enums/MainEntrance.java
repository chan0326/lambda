package com.erich.api.enums;
import com.erich.api.board.BoardView;

import java.util.Arrays;
import java.util.function.Supplier;

public enum MainEntrance {
    EXIT("x",()-> "x"),
    BOARD("b",()->"b"),
    USER("u",()->"u"),
    ACCOUNT("m",()->"m"),
    CRAWLER("c",()->"c"),
    ARTICLE("a",()->"a");

    private final String input;

    private final Supplier<String>supplier;


    MainEntrance(String input, Supplier<String> supplier) {
        this.input = input;
        this.supplier = supplier;
    }
    static MainEntrance GetEnum (String a){
       return Arrays.stream(values()).filter(i->i.input.equals(a)).findFirst().orElseThrow(() -> new IllegalArgumentException("올바른 값이 아닙니다."));
    }


}
