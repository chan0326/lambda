package com.erich.api.menu;

import com.erich.api.enums.Message;

import java.sql.SQLException;
import java.util.List;

public class MenuController {
    private static MenuController instance = new MenuController();
    private  MenuServiceImpl menuServiceimpl;

    private MenuController( ) {
        this.menuServiceimpl = MenuServiceImpl.getInstance();
    }

    public static MenuController getInstance(){
        return instance;
    }


    public Message makeMenuTable(){
        return menuServiceimpl.makeMenuTable();
    }
    public Message removeMenuTable(){
        return menuServiceimpl.removeTable();
    }

    public List<?> getMenusByCategory(String category){
        return menuServiceimpl.getMenusByCategory(category);
    }
}
