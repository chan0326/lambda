package com.erich.api.article;

import java.sql.SQLException;
import java.util.List;

public class ArticleController {

    private ArticleServicelmpl articleServicelmpl;

    ArticleController(){
        this.articleServicelmpl = ArticleServicelmpl.getInstance();
    }



    public List<?> findarticlecle() throws SQLException {
        return articleServicelmpl.findarticle();
    }
}
