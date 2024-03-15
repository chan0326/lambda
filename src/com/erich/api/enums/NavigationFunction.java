package com.erich.api.enums;

import com.erich.api.account.AccountView;
import com.erich.api.article.ArticleView;
import com.erich.api.crawler.CrawlerView;
import com.erich.api.member.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public enum NavigationFunction {
    EXIT("e",i->"x"),
    USER("u", i-> {
        try {
            UserView.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "";
    }),
    ARTICLE("a", i-> {
        try {
            ArticleView.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "";
    }),
    ACCOUNT("m", i-> {
        AccountView.main(i);
        return "";
    }),
    CRAWLER("c", i-> {
        try {
            CrawlerView.main(i);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "";
    }),
//    BOARD("b", i->""),
    //NAVIGATION_ERROR("error",i->"er")

    ;

    private final String name;
    private final Function<Scanner,String> function;



     NavigationFunction(String name, Function<Scanner, String> function) {
        this.name = name;
        this.function = function;
    }

    public static String navimain(Scanner sc) {
        System.out.println(
                "x-Exit u-user a-Article ac-Account c-Crawler b-Board");
        String msg = sc.next();
        System.out.println("선택한 메뉴 : "+ msg);

        return Stream.of(values()).filter(i->i.name.equals(msg)).findAny().orElseGet(()->EXIT).function.apply(sc);

    }
}
