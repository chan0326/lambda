package com.erich.api.crawler;

import com.erich.api.member.UserController;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class CrawlerView {
    public static void main(Scanner sc) throws IOException {
        Iterator<Element>  rank;
        Iterator<Element> artist;
        Iterator<Element> title;
        Map<String,?> map;
        CrawlerController controller = new CrawlerController();
        System.out.println("authController.addUsers 결과 : ");
        while(true){
            System.out.println("[사용자메뉴]\n" +
                    "0-종료\n " +
                    "1-벅스뮤직\n " +
                    "2-멜론 뮤직\n " +
                    "3-로그인\n " +
                    "4-로그인 결과\n" +
                    "5-탈퇴\n " +
                    "6-회원목록\n ");
            switch (sc.next()){
                case "0":
                    System.out.println("종료");
                    return;
                case "1":
                    System.out.println("1-벅스뮤직");
                    map = controller.findBugsMusic(sc);
                    System.out.println("2-벅즈뮤직 결과");
                    rank = (Iterator<Element>) map.get("key2");
                    artist = (Iterator<Element>) map.get("key1");
                    title = (Iterator<Element>) map.get("key0");
                    while (rank.hasNext()) {
                        System.out.println(rank.next().text() + "위 " + artist.next().text() + " - " + title.next().text());
                    }
                    break;
                case "2":
                    System.out.println("3-멜론뮤직");
                    map = controller.findMelonMusic(sc);
                    System.out.println("2-멜론뮤직 결과");

                    rank = (Iterator<Element>) map.get("titleMelon");
                    artist = (Iterator<Element>) map.get("artistMelon");
                    title = (Iterator<Element>) map.get("rankMelon");
                    while (rank.hasNext()) {
                        System.out.println(rank.next().text() + "위 " + artist.next().text() + " - " + title.next().text());
                    }
                    break;
                case "3":
                    System.out.println("3-로그인");
                    break;
                case "4":
                    System.out.println("4-로그인 결과");
                case "5":
                    System.out.println("5-탈퇴");
                    break;
                case "6":
                    System.out.println("6-회원목록");

                    break;



            }

        }

    }
}
