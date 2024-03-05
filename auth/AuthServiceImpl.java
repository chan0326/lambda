package auth;

import common.AbstractService;
import enums.Message;
import member.Member;

import java.util.*;

public class AuthServiceImpl extends AbstractService implements AuthService {
    private  static AuthServiceImpl instance = new AuthServiceImpl();

    Map<String, Member> users ;

    List<?> ms ;



    private AuthServiceImpl(){
        this.users =  new HashMap<>();
        this.ms = new ArrayList<>();
    }
    public static AuthServiceImpl getInstance(){
        return instance;
    }


    @Override
    public String addUsers() {
        return null;
    }

    @Override
    public String login(Member user) {
        return null;
    }

    @Override
    public String updatePassword(Member user) {
        return null;
    }

    @Override
    public List<?> findUsersByName(String name) {
        return null;
    }

    @Override
    public List<?> findUsersByJob(String job) {
        return null;
    }

    @Override
    public Map<String, ?> getUserMap() {
        return null;
    }

    @Override
    public Message save(Object o) {
        return null;
    }

    @Override
    public Message save(Member member) {
        users.put(member.getUsername(),member);
        return Message.SUCCESS;
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public Optional findById(Long id) {
        return Optional.empty();
    }

    @Override
    public String count() {
        return null;
    }

    @Override
    public Optional getOne(String id) {
        return Optional.empty();
    }

    @Override
    public String delete(Object o) {
        return null;
    }

    @Override
    public String deleteAll() {
        return null;
    }

    @Override
    public Boolean existById(Long id) {
        return null;
    }
}
