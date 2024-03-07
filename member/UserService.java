package member;

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
}