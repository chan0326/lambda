package com.erich.api.menu;

import com.erich.api.enums.Message;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.erich.api.enums.Message.FAIL;

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

    public List<?> lsList(String category) throws SQLException {
        return menuServiceimpl.lsList(category);
    }

    public Message retrunMessage() throws SQLException {
        Message m = menuServiceimpl.returnMessage();
        return m;
    }


}
