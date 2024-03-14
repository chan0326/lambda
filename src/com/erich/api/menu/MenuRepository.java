package com.erich.api.menu;

import com.erich.api.member.MemberRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class MenuRepository {
    private static MenuRepository instance;

    static {
        try {
            instance = new MenuRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Connection connection;
    private PreparedStatement pstmt ;

    public MenuRepository() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/erichgammadb", "erichgamma",
                "erichgammadb"
        );


    }
    public static MenuRepository getInstance(){
        return instance;
    }


    public  List<?> findMenu(){
        return null;
    }


    public String creattable() throws SQLException {
        String sql = "CREATE TABLE menu (id INT AUTO_INCREMENT PRIMARY KEY, item VARCHAR(20)" +
                ",category VARCHAR(20))";


        pstmt = connection.prepareStatement(sql);
        return (pstmt.executeUpdate() >=0)?"성공" :"실패" ;
    }

    public String inserttable() throws SQLException {
        String sql = "insert into menu (item,category) values ('1-회원가입','users')";

        pstmt = connection.prepareStatement(sql);
        return (pstmt.executeUpdate() >=0)?"성공" :"실패" ;
    }
}
