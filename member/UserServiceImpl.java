package member;


import common.AbstractService;
import common.UtilService;
import common.UtilServiceImpl;
import enums.Message;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

public class UserServiceImpl extends AbstractService<Member> implements UserService {


    private static UserServiceImpl instance = new UserServiceImpl();
    Map<String, Member> users;
    MemberRepository memberRepository;
    private UserServiceImpl(){
        this.users = new HashMap<>();
        this.memberRepository = MemberRepository.getInstance();
    }
    public static UserServiceImpl getInstance(){
        return instance;}



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
                            .job(util.creatRandomJob())
                            .build());
        }
        users =map;

        return users.size()+"더미값 추가";
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
    public String updatePassword(Member user) {
        if (users.get(user.getUsername()) !=null){
            users.get(user.getUsername()).setPw(user.getPw());
        }else {
            System.out.println("존재하지 않는 ID입니다.");
        }
        return "성공";
    }
    @Override
    public List<?> findUsersByName(String name) {
        return users .values().stream().filter(i ->i.getName().equals(name)).collect(Collectors.toList());
    }

    @Override
    public List<?> findUsersByJob(String job) {
        return users.values().stream().filter(i->i.getJob().equals(job)).collect(Collectors.toList());
    }
    @Override
    public Map<String, Member> getUserMap() {
        return users;
    }

    @Override
    public String test() {
        return memberRepository.test();

    }

    @Override
    public Map<String, ?> findUser() {
        return null;
    }

    @Override
    public List<?> findUsers() throws SQLException {
        return memberRepository.findUsers();
    }


    @Override
    public Message save(Member member) {
        users.put(member.getUsername(), member);
        return Message.SUCCESS;
    }

    @Override
    public List<Member> findAll() {
        return  new ArrayList<>(users.values());
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.of(users.values()
                .stream()
                .filter(i->i.getId().equals(id))
                .collect(Collectors.toList()).get(0));
    }

    @Override
    public String count() {
        return users.size()+"";
    }

    @Override
    public Optional<Member> getOne(String id) {
        return Optional.of(users.get(id));
    }

    @Override
    public String delete(Member member) {
        users.remove(member.getUsername());
        return "회원삭제";
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
