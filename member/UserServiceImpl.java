package member;


import common.UtilService;
import common.UtilServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    private static UserService instance = new UserServiceImpl();
    Map<String, Member> users;
    private UserServiceImpl(){
        this.users = new HashMap<>();
    }
    public static UserService getInstance(){return instance;}


    @Override
    public String addUsers() {
        Map<String, Member> map= new HashMap<>();
        UtilService util = UtilServiceImpl.getInstance();

        for (int i=0;i<5;i++){
            String username = util.CreatRandomUsername();
            map.put(username,
                    Member.builder()
                            .username(username)
                            .pw("1")
                            .pwAgain("1")
                            .name(util.creatRadomName())
                            .build());
        }
        users =map;

        return users.size()+"더미값 추가";
    }

    @Override
    public String join(Member user) {
        users.put(user.getUsername(),user);
        return "회원가입 성공";
    }

    @Override
    public String login(Member user) {
        if (users.get(user.getUsername())!= null && users.get(user.getUsername()).getPw().equals(user.getPw())){
            System.out.println("로그인에 성공하였습니다");
        }else {
            System.out.println("아이디,비번이 오류입니다.");
        }
        return "";
    }

    @Override
    public Member findUserById(String username) {
        if (users.get(username) != null){
            System.out.println(username+"의 정보입니다."+users);
        }else {
            System.out.println("존재하지 않는 ID입니다.");
        }
        return null;
    }

    @Override
    public String updatePassword(Member user) {
        if (users.get(user.getUsername()) !=null){
            users.get(user.getUsername()).setPw(user.getPw());
        }else {
            System.out.println("존재하지 않는 ID입니다.");
        }
        return "성공";
    }

    @Override
    public String deleteUser(String username) {
        if (users.get(username) !=null){
            users.remove(username);
        }else {
            System.out.println("존재하지 않는 ID입니다.");
        }
        return "성공";
    }

    @Override
    public List<Member> getUserList() {

        return new ArrayList<>(users.values());
    }

    @Override
    public List<?> findUsersByName(String name) {
//        ArrayList arrayList = new ArrayList<>(users.values());
        return users .values().stream().filter(i ->i.getName().equals(name)).collect(Collectors.toList());
    }

    @Override
    public List<?> findUsersByJob(String job) {
        return users.values().stream().filter(i->i.getJob().equals(job)).collect(Collectors.toList());
    }

    @Override
    public String countUsers() {
        return users.size()+"명";
    }

    @Override
    public Map<String, Member> getUserMap() {
        return users;
    }
}
