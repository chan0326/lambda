package com.erich.api.enums;

import com.erich.api.member.UserController;
import com.erich.api.menu.MenuController;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;



public enum UserRouter {
    EXIT("0", i ->{
        System.out.println("0-종료");
        return false;
    }),
    Join("1", i ->{
        System.out.println("1-회원가입");
        System.out.println(UserController.getinstance().join(i));
        return true;}),
    Login("2", i ->{
        System.out.println("2-로그인");
        System.out.println(UserController.getinstance().login(i));
        return true;}),
    FindId("3", i ->{
        System.out.println("3-ID검색");
//                    System.out.println(userController.findUserById(sc));
//                    System.out.println(userController.findUser(sc));
        return true;}),
    UpdatePw("4", i ->{
        System.out.println("4-비번변경");
        System.out.println(UserController.getinstance().updatePassword(i));
        return true;}),
    Delete("5",i ->{
        System.out.println("5-탈퇴");
        System.out.println(UserController.getinstance().deleteUser(i));
        return true;}),
    MemberList("ls", i ->{
        List<?> Members = null;
        try {
            Members = UserController.getinstance().findUsers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Members.forEach((j)-> System.out.println(j));
        return true;}),
    SearchName("7", i ->{
        System.out.println("7-이름검색");
        System.out.println(UserController.getinstance().findUsersByName(i));
        UserController.getinstance().findUsersByName(i).forEach((j)->{
            System.out.println(j);
        });return true;}),
    SearchJob("8", i ->{
        System.out.println("8-직업검색");
        System.out.println(UserController.getinstance().findUsersByJob(i));
        UserController.getinstance().findUsersByJob(i).forEach(System.out::println);
        return true;}),
    Count("9", i ->{
        System.out.println("9-회원수");
        System.out.println(UserController.getinstance().countUsers());
        return true;}),
    UserMap("10", i ->{
        System.out.println("10-UserMap");
        UserController.getinstance().getUserMap().forEach((k, v)->{
            System.out.printf("아이디: %s, 회원정보: %s", k, v);
        });
        return true;}),
    Touch("touch", i ->{
        System.out.println("touch-테이블생성");
        try {
            UserController.getinstance().creatTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;}),
    TouchRow("touchrow",i ->{
        System.out.println("touchrow-테이블행추가");
        try {
            UserController.getinstance().tableadd(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;}),
    TableDelete("rm", i ->{
        System.out.println("rm-테이블삭제");
        try {
            UserController.getinstance().deleteTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;})
    ;
    private final String input;

    private final Predicate<Scanner> Predicate;

    UserRouter(String input,  Predicate< Scanner> Predicate) {
        this.input = input;
        this.Predicate = Predicate;

    }

    public static boolean execute( Scanner scanner ) throws SQLException {

       List<?>ls =MenuController.getInstance().lsList("user");
        System.out.println(ls);

        String boo = scanner.next();
        return Stream.of(values()).filter(i->i.input.equals(boo)).findAny().orElseGet(()->EXIT).Predicate.test(scanner);
    }

}
