package auth;

import common.UtilService;
import common.UtilServiceImpl;
import member.Member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuthServiceImpl implements AuthService {
    private  static AuthService instance = new AuthServiceImpl();

    Map<String, Member> users ;

    List<?> ms ;



    private AuthServiceImpl(){
        this.users =  new HashMap<>();
        this.ms = new ArrayList<>();
    }
    public static AuthService getInstance(){
        return instance;
    }




    @Override
    public String addusers() {
        Map<String , Member> map = new HashMap<>();
        UtilService utilService = UtilServiceImpl.getInstance();
        for (int i =0 ;i<5;i++){
            String username = utilService.CreatRandomUsername();
            map.put(username,Member.builder()
                            .username(username)
                            .name(utilService.creatRadomName())
                    .build());
        }
        users = map;
        return users.size()+"개 더미값 추가";
    }

    @Override
    public String count() {
        System.out.println("회원수 : "+users.size()+"명");
        return "";
    }

    @Override
    public List<Member> findUsersByName(String name) {
        new ArrayList<>(users.values());
        return null;
    }


    @Override
    public String getUserList() {
        System.out.println(users+"\n");
        return "";
    }


    @Override
    public String join(Member member) {
        users.put(member.getUsername(), member);
        System.out.println("회원가입 성공");
        return "";
    }

    @Override
    public String login(Member member) {
        Member mapInusers = users.get(member.getUsername());
        if (mapInusers== null){
            System.out.println("아이디,비번이 틀렸습니다");
        }else {
            if (member.getPw().equals(mapInusers.getPw())){
                System.out.println("로그인에 성공하였습니다");
            }else {
                System.out.println("비밀번호가 틀렸습니다");
            }
        }
        return "";
    }

    @Override
    public String idResarch(String username) {
        Member mapInusers = users.get(username);
        if (mapInusers == null){
            System.out.println("해당 ID가 존재하지 않습니다");
        }else {
            System.out.println("해당 ID가 존재합니다");
            System.out.println(mapInusers);
        }

        return "";
    }

    @Override
    public String findUserById(Member member) {
        Member Mapinuser = users.get(member.getUsername());
        if (Mapinuser == null){
            System.out.println("ID가 틀렸습니다");
        }else {
            System.out.println("비밀번호를 수정하였습니다");
            Mapinuser.setPw(member.getPw());
        }
        return "";
    }

    @Override
    public String deleteUser(String username) {
        Member Mapinuser = users.get(username);
        if (Mapinuser == null){
            System.out.println("ID가 틀렸습니다");
        }else {
            System.out.println(username+"ID를 삭제하였습니다.");
            users.remove(username);
        }
        return "";
    }
}
