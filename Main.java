import account.AcoountView;
import board.BoardView;
import member.UserView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("0-종료 1-Bord 2-user 3-Acoount");
            switch (sc.next()){
                case "0":
                    return;
                case "1": BoardView.main();break;
                case "2": UserView.main(sc);break;
                case "3": AcoountView.main(sc);break;

            }


        }
    }
}