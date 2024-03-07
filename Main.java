import account.AcoountView;
//import board.BoardView;
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
            System.out.println("0-종료 1-Bord 2-user 3-Acoount 4-crawler 5-article");
            switch (sc.next()){
                case "0":
                    return;
//                case "1": BoardView.main();break;
                case "2": UserView.main(sc);break;
                case "3": AcoountView.main(sc);break;
                case "4": CrawlerView.main(sc);break;
                case "5": ArticleView.main(sc);break;

            }


        }
    }
}