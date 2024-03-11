package com.erich.api.member;

import com.erich.api.article.Article;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MemberRepository {
    private static MemberRepository instance;
    private PreparedStatement pstmt ;
    private ResultSet rs;


    static {
        try {
            instance = new MemberRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Connection connection;

    private MemberRepository() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/erichgammadb",
                "erichgamma",
                "erichgammadb");
        pstmt = null;
        rs = null;
    }

    public static MemberRepository getInstance() {
        return instance;
    }

    public String test() {
        return "UserRepository 연결";
    }

    public List<?> findUsers() throws SQLException {
        List<Member> ls = new ArrayList<>();
        String sql = "select * from users";
        System.out.println("sql : " + sql);
         pstmt = connection.prepareStatement(sql);
         rs = pstmt.executeQuery();
        if (rs.next()) {
            do {
                ls.add(Member.builder()
                        .id(rs.getLong("id"))
                        .name(rs.getString("name"))
                        .username(rs.getString("username"))
                        .phone(rs.getString("phone"))
                        .password(rs.getString("password"))
                        .job(rs.getString("job"))
                        .build());

            } while (rs.next());

        } else {
            System.out.println("데이터가 없습니다.");
        }
        return ls;
    }

    public String creatTable() throws SQLException {

        try {String sql = "CREATE TABLE users (id INT AUTO_INCREMENT PRIMARY KEY, username VARCHAR(20),"
                + " password varchar(20) , name VARCHAR(20),phone VARCHAR(20),height VARCHAR(20)," +
                "weight VARCHAR(20),job VARCHAR(20))";


             pstmt = connection.prepareStatement(sql);
            pstmt.execute(sql);
            System.out.println("테이블생성,테이블 개수:");
        }catch (Exception e1){
            System.out.println("테이블 생성 실패 이유 : " + e1);

        }

        return "테이블생성성공";
        // retrun (ex ==0) ? "succes" : "Fail"; 삼항 연산자.
    }

    public String deleteTable() throws SQLException {
        try {
            String sql = "Drop table users";
             pstmt = connection.prepareStatement(sql);
            int result = pstmt.executeUpdate(sql);
            System.out.println("데이터 삭제 성공!"+result);
        } catch(Exception e) {
            System.out.println("데이터 삭제 실패 이유 : " + e);
        }

        return "테이블 삭제 성공";
    }

    public String tableadd() {

        return "내용추가 성공";
    }
}
