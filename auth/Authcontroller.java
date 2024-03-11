package com.erich.api.auth;



import com.erich.api.enums.Message;
import com.erich.api.member.Member;

import java.util.List;
import java.util.Scanner;

public class Authcontroller {
    AuthServiceImpl as ;

    public Authcontroller() {
        this.as =  AuthServiceImpl.getInstance();
    }

//    public String addusers() {

//        return as.addusers();
//    }

    public String count() {
        return as.count();
    }

    public Message join(Scanner sc) {
        System.out.println("ID, " +
                "비밀번호, " +
                "비밀번호 확인, " +
                "전화번호, " +
                "주소, " +
                "직업을 입력해주세요");
        return as.save(Member.builder()
                        .username(sc.next())
                        .password(sc.next())
                        .pwAgain(sc.next())
                        .phone(sc.next())
                        .job(sc.next())
                .build());
    }

//    public String getUserList() {
//        return as.getUserList();
//    }

    public String login(Scanner sc) {
        System.out.println("ID,PW을 입력해주세요");
        return as.login(Member.builder()
                .username(sc.next())
                .password(sc.next())
                .build()
        );
    }

//    public String idResarch(Scanner sc) {
//        System.out.println("검색하려는 ID를 입력하세요");
//        return as.idResarch(sc.next());
//    }

//    public String findUserById(Scanner sc) {
//        System.out.println(" ID입력");
//        System.out.println("수정 PW입력");
//        return as.findUserById(Member.builder()
//                .username(sc.next())
//                .pw(sc.next())
//                .build());
//    }

//    public String deleteUser(Scanner sc) {
//        System.out.println("삭제할 ID를 입력하세요");
//        return as.deleteUser(sc.next());
//    }
//
//    public List<Member> findUsersByName(Scanner sc) {
//        System.out.println("찾는 이름을 입력하세요");
//        return as.findUsersByName(sc.next());
//    }
}
