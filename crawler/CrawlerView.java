package crawler;

import member.UserController;

import java.util.Map;
import java.util.Scanner;

public class CrawlerView {
    public static void main(Scanner sc) {
        CrawlerController controller = new CrawlerController();
        System.out.println("authController.addUsers 결과 : ");
        while(true){
            System.out.println("[사용자메뉴]\n" +
                    "0-종료\n " +
                    "1-벅스뮤직\n " +
                    "2-벅즈뮤직 결과\n " +
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
                    Map<String,?> map = controller.findBugsMusic(sc);
                    break;
                case "2":
                    System.out.println("2-벅즈뮤직 결과");
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
