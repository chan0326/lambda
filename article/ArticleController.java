package article;

import java.sql.SQLException;
import java.util.List;

public class ArticleController {
    private static ArticleController instance = new ArticleController();

    private ArticleServicelmpl articleServicelmpl;

    private ArticleController(){
        this.articleServicelmpl = ArticleServicelmpl.getInstance();
    }

    public static ArticleController getInstance() {
        return instance;
    }

    public List<?> findarticlecle() throws SQLException {
        return articleServicelmpl.findarticle();
    }
}
