package article;

import java.sql.*;
import java.util.List;

public class ArticleRepository {
    private static ArticleRepository instance;

    static {
        try {
            instance = new ArticleRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Connection connection;

    private ArticleRepository() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/erichgammadb"  ,"erichgamma",
                "erichgammadb"
        );

    }


    public static ArticleRepository getInstance() {
        return instance;
    }

    public List<?> findList() throws SQLException {
        String sql = "select * from articles";
        System.out.println("sql : "+ sql);
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        if(rs.next()){
            do{
                System.out.printf("ID: %d\t Title: %s\t Content: %s\t Writer: %s\n",
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getString("writer"));
                System.out.println();
            }while(rs.next());

        }else{
            System.out.println("데이터가 없습니다.");
        }

        rs.close();
        pstmt.close();
        connection.close();

        return null;
    }
}