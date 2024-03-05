package member;


import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class UserController {
    UserService userService ;

    public UserController() {
        this.userService = UserServiceImpl.getInstance();
    }

    public String addUsers() {
        return userService.addUsers();
    }

    public String join(Scanner sc) {
        System.out.println("ID, " +
                "비밀번호, " +
                "비밀번호 확인, " +
                "이름, " +
                "전화번호, " +
                "주소, " +
                "직업을 입력해주세요");
        return userService.join(Member.builder()
                        .username(sc.next())
                        .pw(sc.next())
                        .pwAgain(sc.next())
                        .name(sc.next())
                        .phoneNumber(sc.next())
                        .adress(sc.next())
                        .adress(sc.next())
                .build());
    }

    public String login(Scanner sc) {
        System.out.println("ID를 입력하세요");
        System.out.println("PW를 입력하세요");
        return userService.login(Member.builder()
                        .username(sc.next())
                        .pw(sc.next())
                .build());
    }

    public Member findUserById(Scanner sc) {
        System.out.println("검색할 ID를 입력하세요");
        return userService.findUserById(sc.next());
    }

    public String updatePassword(Scanner sc) {
        System.out.println(" ID를 입력하세요");
        System.out.println("수정할 PW를 입력하세요");
        return userService.updatePassword(Member.builder()
                        .username(sc.next())
                        .pw(sc.next())
                .build());
    }

    public String deleteUser(Scanner sc) {
        System.out.println("삭제할 ID를 입력하세요");
        return userService.deleteUser(sc.next());
    }

    public List<?> getUserList() {
        System.out.println("전체 목록 출력");
        return userService.getUserList();
    }

    public  List<?> findUsersByName(Scanner sc) {
        System.out.println("찾을 Name을 입력하세요");
        return userService.findUsersByName(sc.next());
    }

    public List<?> findUsersByJob(Scanner sc) {
        System.out.println("찾을 job을 입력하세요");
        return  userService.findUsersByJob(sc.next());
    }

    public String countUsers() {
        return userService.countUsers();
    }

    public Map<String, ?> getUserMap() {
        return userService.getUserMap();
    }
}


