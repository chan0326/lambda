package com.erich.api.menu;

import java.sql.SQLException;
import java.util.List;

public class MenuController {
    private static MenuController instance = new MenuController();
    private  MenuServiceImpl menuServiceimpl;

    public MenuController( ) {
        this.menuServiceimpl = menuServiceimpl;
    }

    public static MenuController getInstance(){
        return instance;
    }

    public List<?>findMenu(){
        return menuServiceimpl.findMenu();
    }

    public String creattable() throws SQLException {
        return menuServiceimpl.creattable();
    }
    public String inserttable() throws SQLException {
        return menuServiceimpl.inserttable();
    }
}
