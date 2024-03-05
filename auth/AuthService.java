package auth;



import member.Member;

import java.util.List;
import java.util.Map;

public interface AuthService {
    String addUsers();
    String login(Member user);
    String updatePassword(Member user);
    List<?> findUsersByName(String name);
    List<?> findUsersByJob(String job);
    Map<String, ?> getUserMap();

}
