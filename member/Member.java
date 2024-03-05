package member;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public class Member {

    private Long id;

    private String pw;

    private String pwAgain;

    private String name;

    private String Username;

    private String phoneNumber;

    private String adress;

    private String job;

    private double height;

    private double weight;
@Builder(builderMethodName = "builder")

    public Member(Long id,String pw, String pwAgain, String name, String username, String phoneNumber, String adress, String job, double height, double weight) {
        this.id = id;
        this.pw = pw;
        this.pwAgain = pwAgain;
        this.name = name;
        this.Username = username;
        this.phoneNumber = phoneNumber;
        this.adress = adress;
        this.job = job;
        this.height = height;
        this.weight = weight;
    }

    public void setPw(String pw) {

    }
}
