package com.erich.api.member;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface UserService {
    String addUsers();
    String login(Member user);
    String updatePassword(Member user);
    List<?> findUsersByName(String name);
    List<?> findUsersByJob(String job);
    Map<String, ?> getUserMap();

    String test();

    Map<String,?> findUser();

    List<?> findUsers() throws SQLException;

    String creatTable() throws SQLException;

    String deleteTable() throws SQLException;

    String tableadd();
}