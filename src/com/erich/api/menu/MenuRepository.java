package com.erich.api.menu;

import com.erich.api.enums.Message;
import com.erich.api.member.MemberRepository;

import java.sql.*;
import java.util.ArrayList;
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
    private ResultSet rs;


    private MenuRepository() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/erichgammadb", "erichgamma",
                "erichgammadb"

        );
        pstmt = null;
        rs = null;
    }
    public static MenuRepository getInstance(){
        return instance;
    }

    public  Message returnMessage() throws SQLException {
        String sql ="";
        pstmt = connection.prepareStatement(sql);
        Message m = null;
        return m;
    }


    public Message makeTable() {
        String sql = "CREATE TABLE IF NOT EXISTS menus (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "category VARCHAR(10) NOT NULL," +
                "item VARCHAR(20) NOT NULL)";
        try {
            pstmt = connection.prepareStatement(sql);
            return pstmt.executeUpdate() >= 0 ? Message.SUCCESS : Message.FAIL;
        } catch (SQLException e){
            System.err.println("SQL Exception Occurred");
            return Message.SQL_ERROR;
        }
    }

    public Message insertMenu(Menu menu)  {
        String sql = "INSERT INTO menus(category, item) VALUES(?,?)";
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, menu.getCategory());
            pstmt.setString(2, menu.getItem());
            return pstmt.executeUpdate() >= 0 ? Message.SUCCESS : Message.FAIL;
        } catch (SQLException e){
            System.err.println("SQL Exception Occurred :" + menu.getCategory() + " " + menu.getItem());
            return Message.SQL_ERROR;
        }
    }
    public Message removeTable() {
        String sql = "DROP TABLE IF EXISTS menus";
        try {
            pstmt = connection.prepareStatement(sql);
            return pstmt.executeUpdate() >= 0 ? Message.SUCCESS : Message.FAIL;
        } catch (SQLException e){
            System.err.println("SQL Exception Occurred");
            return Message.SQL_ERROR;
        }
    }
    public List<?> getMenusByCategory(String category){
        String sql = "SELECT m.item FROM menus m WHERE category = ?";
        List<Menu> menus = new ArrayList<>();
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, category);
            rs = pstmt.executeQuery();
            while(rs.next())    menus.add(Menu.builder().item(rs.getString(1)).build());
        } catch (SQLException e){
            System.err.println("SQL Exception Occurred");
            return menus;
        }
        return menus;
    }



    public List<?> lsList(String category) throws SQLException {
        List<Menu> ls =new ArrayList<>();
        String sql ="select * from menus where category = ?";
        pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,category);
        rs =pstmt.executeQuery();
        if (rs.next()){
            do {
                Menu m =Menu.builder().item(rs.getString("item")).category(rs.getString("category")).build();
                ls.add(m);
            }while (rs.next());
        }else {
            System.out.println("NO DATA");
        }
        //리턴 타입이 messsage인 경우 이거는 message를 가져옴
//        Message res = (pstmt.executeQuery() >= 0)?Message.SUCCESS:Message.FAIL;
        // 리턴 타입이 리스트인 경우
        return ls;
    }


}
