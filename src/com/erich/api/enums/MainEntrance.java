package com.erich.api.enums;

import com.erich.api.account.AccountView;
import com.erich.api.article.ArticleView;
import com.erich.api.board.BoardView;
import com.erich.api.crawler.CrawlerView;
import com.erich.api.member.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum MainEntrance {
     EXIT("e", i -> {
         System.out.println("EXIT");
         return false;
     }),
     USER("b", i -> {
         BoardView.main(i);
         return true;
     }),
     ACCOUNT("m", i -> {
         AccountView.main(i);
         return true;
     }),
     CRAWLER("c", i -> {
         try {
             CrawlerView.main(i);
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
         return true;
     }),
     Article("a", i -> {
         try {
             ArticleView.main(i);
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }
         return true;
     }),
     User("u", i -> {
         try {
             UserView.main(i);
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }
         return true;
     }),
     ERROR("error", i -> {
         System.out.println("Wrong Input");
         return true;
     });

     private final String name;
     private final Predicate<Scanner> predicate;


     MainEntrance(String name, Predicate<Scanner> predicate) {
         this.name = name;
         this.predicate = predicate;
     }

     public static Boolean mainEntrance(Scanner scan){
         System.out.println("e-Exit, b-Board,u-User, m-Account, c-Crawler, a-Article");
         String str = scan.next();
         return Stream.of(values()).filter(i -> i.name.equals(str))
                 .findAny().orElse(ERROR).predicate.test(scan);
     }
 }


