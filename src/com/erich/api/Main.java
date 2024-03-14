package com.erich.api;

import com.erich.api.account.AcoountView;
import com.erich.api.board.BoardView;
import com.erich.api.article.ArticleView;

import com.erich.api.crawler.CrawlerView;
import com.erich.api.enums.MainEntrance;
import com.erich.api.enums.NavigationFunction;
import com.erich.api.instance.InstanceView;
import com.erich.api.member.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Predicate;




public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        Scanner sc = new Scanner(System.in);
//        MainEntrance.mainEntrance(sc);
         NavigationFunction.navimain(sc);
    }
}