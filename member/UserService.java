package member;

import java.util.List;
import java.util.Map;

public interface UserService {
    String addUsers();
    String join(Member user);
    String login(Member user);
    Member findUserById(String username);
    String updatePassword(Member user);
    String deleteUser(String username);
    List<?> getUserList();
    List<?> findUsersByName(String name);
    List<?> findUsersByJob(String job);
    String countUsers();

    Map<String, ?> getUserMap();

}