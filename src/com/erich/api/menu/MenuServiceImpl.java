package com.erich.api.menu;

import java.sql.SQLException;
import java.util.List;

public class MenuServiceImpl implements  MenuService{
    private static MenuServiceImpl instance = new MenuServiceImpl();
    private MenuRepository menuRepository;

     MenuServiceImpl() {
        this.menuRepository = menuRepository;
    }

    public MenuServiceImpl getInstance () {
        return instance;

    }


    public  List<?> findMenu() {
         return menuRepository.findMenu();
    }

    @Override
    public String creattable() throws SQLException {
        return menuRepository.creattable();
    }

    @Override
    public String inserttable() throws SQLException {
        return menuRepository.inserttable();
    }


}
