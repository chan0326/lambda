package com.erich.api.menu;

import com.erich.api.enums.Message;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuServiceImpl implements  MenuService{
    private static MenuServiceImpl instance = new MenuServiceImpl();
    private MenuRepository menuRepository;

     private MenuServiceImpl() {
        this.menuRepository = MenuRepository.getInstance();
    }

    public static MenuServiceImpl getInstance() {
        return instance;

    }


    @Override
    public Message makeMenuTable() {
        menuRepository.makeTable();
        this.insertMenus();
        return Message.SUCCESS;
    }

    @Override
    public Message removeTable() {
        return menuRepository.removeTable();
    }

    @Override
    public List<?> getMenusByCategory(String category) {
        return menuRepository.getMenusByCategory(category);
    }

    @Override
    public List<?> lsList(String category) throws SQLException {
        return menuRepository.lsList(category);
    }

    @Override
    public Message returnMessage() throws SQLException {
         Message m = menuRepository.returnMessage();
        return m;
    }




    private void insertMenus(){
        /**
         * 공통 메뉴 명령어 정의
         * x means 'Exit'
         * mk means 'Create Table'
         * cat means 'Find The One'
         * touch means 'Insert One'
         * ch-* means 'Change What'
         * rm means 'Delete Row'
         * ls-a means 'All List'
         * ls-n means 'Find By Name'
         * ls-* means 'Something List'
         * cnt means 'Count'
         * 이 외에 일상적이 아닌 단어는 약어 사용
         * withdraw -> with
         * deposit -> depo
         * balance -> bal
         * */
        String[] categories = {"navigate", "user", "article", "account", "soccer","board"};
        String[][] menus = {{"x-Exit", "u-User", "a-article",  "m-Account", "c-Crawler"},
                {"x-Exit","mk :User Table", "joi-회원가입", "log-로그인", "findId -ID 검색", "ch-pw -PW변경", "rm-탈퇴", "ls-a-회원목록", "ls-n-이름 검색", "ls-job-직업 검색", "cnt-회원수"},
                {"x-Exit", "mk :Account Table","1-Create","2-Deposit", "3-Withdraw",  "4-Balance", "5-RemoveAccount", "6-AccountList"},
                {"x-Exit","mk :Board Table", "1-Board"},
                {"x-Exit","mk :article Table", "1-article"},
                {"x-Exit","mk :Soccer Table"},
                };

        for(int i = 0; i < menus.length; i++)
            for(int j = 0; j < menus[i].length; j++)
                menuRepository.insertMenu(Menu.builder().category(categories[i]).item(menus[i][j]).build());
    }
}
