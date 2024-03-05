import account.AcoountView;
import board.BoardView;
import crawler.CrawlerView;
import member.UserView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("0-종료 1-Bord 2-user 3-Acoount 4-crawler");
            switch (sc.next()){
                case "0":
                    return;
                case "1": BoardView.main();break;
                case "2": UserView.main(sc);break;
                case "3": AcoountView.main(sc);break;
                case "4": CrawlerView.main(sc);break;

            }


        }
    }
}