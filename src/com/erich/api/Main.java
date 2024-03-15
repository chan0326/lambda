package com.erich.api;

import com.erich.api.enums.NavigationFunction;
import com.erich.api.menu.MenuController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        System.out.println(MenuController.getInstance().makeMenuTable());
        Scanner sc = new Scanner(System.in);
//        MainEntrance.mainEntrance(sc);
//         NavigationFunction.navimain(sc);
    }
}