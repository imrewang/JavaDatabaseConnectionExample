package mysqlYF;

public class User {
    private String userPwd;
    private String userName;
    public User(String userName, String userPwd) {
        this.userName = userName;
        this.userPwd = userPwd;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserPwd() {
        return userPwd;
    }
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String toString() {
        return "User [userName=" + userName + ", userPwd=" + userPwd + "]";
    }

}

