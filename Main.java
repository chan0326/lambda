package com.erich.api;

import com.erich.api.account.AcoountView;
import com.erich.api.board.BoardView;
import com.erich.api.article.ArticleView;

import com.erich.api.crawler.CrawlerView;
import com.erich.api.instance.InstanceView;
import com.erich.api.member.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("x-exit b-Bord u-User m-Acoount c-crawler a-article");
            switch (sc.next()){
                case "x":
                    return;
                case "1": BoardView.main();break;
                case "u": UserView.main(sc);break;
                case "m": AcoountView.main(sc);break;
                case "c": CrawlerView.main(sc);break;
                case "a": ArticleView.main(sc);break;

            }


        }
    }
}