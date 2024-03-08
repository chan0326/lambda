package member;


import enums.Message;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;


public class UserController {
    UserServiceImpl userService  ;

    public UserController() {
        this.userService = UserServiceImpl.getInstance();
    }

    public  List<?> findUsers() throws SQLException {
        return userService.findUsers();
    }

    public String addUsers() {
        return userService.addUsers();
    }

    public Message join(Scanner sc) {
        System.out.println("ID, " +
                "비밀번호, " +
                "비밀번호 확인, " +
                "이름, " +
                "전화번호, " +
                "주소, " +
                "직업을 입력해주세요");
        return userService.save(Member.builder()
                        .username(sc.next())
                        .password(sc.next())
                        .pwAgain(sc.next())
                        .name(sc.next())
                        .phone(sc.next())
                        .job(sc.next())
                .build());
    }

    public String login(Scanner sc) {
        System.out.println("ID를 입력하세요");
        System.out.println("PW를 입력하세요");
        return userService.login(Member.builder()
                        .username(sc.next())
                        .password(sc.next())
                .build());
    }

    public Optional<Member> findUserById(Scanner sc) {
        System.out.println("검색할 ID를 입력하세요");
        return userService.findById(sc.nextLong());
    }

    public String updatePassword(Scanner sc) {
        System.out.println(" ID를 입력하세요");
        System.out.println("수정할 PW를 입력하세요");
        return userService.updatePassword(Member.builder()
                        .username(sc.next())
                        .password(sc.next())
                .build());
    }

    public String deleteUser(Scanner sc) {
        System.out.println("삭제할 ID를 입력하세요");
        return userService.delete(Member.builder().username(sc.next()).build());
    }

    public List<?> findAll() {
        System.out.println("전체 목록 출력");
        return userService.findAll();
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
        return userService.count();
    }

    public Map<String, ?> getUserMap() {
        return userService.getUserMap();
    }


    public String test() {
        return userService.test();
    }

    public Map<String,?> findUser(Scanner sc) {
        return userService.findUser();
    }

    public String creatTable() throws SQLException {
        return userService.creatTable();

    }

    public String deleteTable() throws SQLException {
        return userService.deleteTable();

    }

    public String tableadd(Scanner sc) {
        return userService.table();
    }
}


