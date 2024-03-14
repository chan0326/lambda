package com.erich.api.menu;

import java.sql.SQLException;
import java.util.List;

public interface MenuService {

    List<?> findMenu();

    String creattable() throws SQLException;

    String inserttable() throws SQLException;

}
