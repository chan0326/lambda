package com.erich.api;

import com.erich.api.enums.Message;
import com.erich.api.enums.NavigationFunction;
import com.erich.api.menu.Menu;
import com.erich.api.menu.MenuController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        MenuController.getInstance().removeMenuTable();
        MenuController.getInstance().makeMenuTable();
        Scanner sc = new Scanner(System.in);
//        MainEntrance.mainEntrance(sc);
        NavigationFunction.navimain(sc);
//        Message message = MenuController.getInstance().retrunMessage();
//        Menu oneMenu = MenuController.getInstance().retrunOneMenu();
//        List<?>  allMenu = MenuController.getInstance().retrunAllMenus();


    }
}