package auth;



import member.Member;

import java.util.List;

public interface AuthService {
    String addusers();

    String getUserList();

    String join(Member member);

    String login(Member member);

    String idResarch(String username);

    String findUserById(Member member);

    String deleteUser(String username);

    String count();


    List<Member> findUsersByName(String name);
}
