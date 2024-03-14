package com.erich.api.article;

import com.erich.api.common.AbstractRepository;
import com.erich.api.common.AbstractService;
import com.erich.api.enums.Message;
import com.erich.api.member.Member;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ArticleServicelmpl extends AbstractService implements ArticleService{
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

    @Override
    public Message save(Object o) {
        return null;
    }

    @Override
    public Message save(Member member) {
        return null;
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public Optional findById(Long id) {
        return Optional.empty();
    }

    @Override
    public String count() {
        return null;
    }

    @Override
    public Optional getOne(String id) {
        return Optional.empty();
    }

    @Override
    public String delete(Object o) {
        return null;
    }

    @Override
    public String deleteAll() {
        return null;
    }

    @Override
    public Boolean existById(Long id) {
        return null;
    }
}
