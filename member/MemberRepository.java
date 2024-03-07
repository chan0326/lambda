package member;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class MemberRepository {

    private static MemberRepository instance = new MemberRepository();

    MemberRepository(){
    }
    public static MemberRepository getInstance(){return instance;}



    public String test(){
        return "UserRepository 연결";
    }

    public void findUsers() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/bitcampdb";
        String userName = "root";
        String password = "rootroot";

        Connection connection = DriverManager.getConnection(url, userName, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from board");

        resultSet.next();
        String name = resultSet.getString("name");
        System.out.println(name);

        resultSet.close();
        statement.close();
        connection.close();
    }
}
