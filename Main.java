import account.AcoountView;
import board.BoardView;
import article.ArticleView;

import crawler.CrawlerView;
import instance.InstanceView;
import member.UserView;

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