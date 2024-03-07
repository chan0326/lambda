package article;

import common.AbstractRepository;

import java.sql.SQLException;
import java.util.List;

public class ArticleServicelmpl implements ArticleService{
    private static ArticleServicelmpl instance = new ArticleServicelmpl();

    private ArticleRepository articleRepository;
    private ArticleServicelmpl(){
      this.articleRepository =ArticleRepository.getInstance();
    }

    public static ArticleServicelmpl getInstance() {
        return instance;
    }

    @Override
    public List<?> findarticle() throws SQLException {
        return articleRepository.findList();
    }
}
