package itcr.mycalendar.entities;

/**
 * Created by Monserrath on 21/2/2018.
 */

public class Users {
    private String nickname;
    private String fullname;
    private String password;

    public Users(String nickname, String fullname, String password) {
        this.nickname = nickname;
        this.fullname = fullname;
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public String getFullname() {
        return fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
