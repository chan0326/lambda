package com.erich.api.article;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ArticleView {

    public static void main(Scanner sc) throws SQLException {
        ArticleController articleController= new ArticleController();

        while (true) {
            System.out.println("[사용자메뉴]\n" +
                    "0-종료\n " +
                    "1-글목록\n " +
                    "2-\n " +
                    "3-");
            switch (sc.next()) {
                case "0":
                    System.out.println("종료");
                    return;
                case "1":
                    System.out.println("1-글목록");
                    List<?>article = articleController.findarticlecle();
                    article.forEach(i-> System.out.println(i));
                    break;
                case "2":
                    System.out.println("2-테이블 생성 ");
                    System.out.println("테이블 생성 성공");
                    break;
                case "3":
                    System.out.println("3-ID검색");
                    break;
                case "4":
                    System.out.println("4-비번변경");
                    System.out.println();
                case "5":
                    System.out.println("5-탈퇴");
                    System.out.println();
                    break;


            }
        }


    }
}