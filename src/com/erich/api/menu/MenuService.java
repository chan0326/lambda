package com.erich.api.menu;

import com.erich.api.enums.Message;

import java.sql.SQLException;
import java.util.List;

public interface MenuService {

    Message makeMenuTable();

    Message removeTable();

    List<?> getMenusByCategory(String category);

    List<?> lsList(String category) throws SQLException;

    Message returnMessage() throws SQLException;


}
