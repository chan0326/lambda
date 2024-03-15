package com.erich.api.enums;

import com.erich.api.account.Accountcontroller;
import com.erich.api.article.ArticleController;
import com.erich.api.menu.MenuController;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum ArticleRouter {
    Exit("0",i->{
        System.out.println("종료");
        return false;}),
    LsText("1",i->{
        List<?> article = null;
        try {
            article = ArticleController.getinstance.findarticlecle();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        article.forEach(j-> System.out.println(j));
        return true;})
    ;
    private final String input;
    private final Predicate<Scanner> predicate;

    ArticleRouter(String input, Predicate<Scanner> predicate) {
        this.input = input;
        this.predicate = predicate;
    }


    public static boolean execute(Scanner sc) throws SQLException {
        List<?> ls = MenuController.getInstance().lsList("article");
        System.out.println(ls);
        String foo =sc.next();
        return Stream.of(values()).filter(i->i.input.equals(foo))
                .findAny().orElseGet(()->Exit).predicate.test(sc);
    }
}
