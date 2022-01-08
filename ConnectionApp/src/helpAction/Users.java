package helpAction;

public class Users {
    private String username;
    private String password;
    private String address;
    private String country;
    private String age;
    private String email;

    private static String loginUsername;
    private static String loginPassword;

    private String emailMesssage;
    private String aboutMessage;
    private String contentMessage;

    public static String getLoginUsername() {return loginUsername;}
    public static void setLoginUsername(String loginUsername) {Users.loginUsername = loginUsername;}
    public static String getLoginPassword() {
        return loginPassword;
    }
    public static void setLoginPassword(String loginPassword) {Users.loginPassword = loginPassword;}
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


    public String getEmailMesssage() {return emailMesssage;}
    public void setEmailMesssage(String emailMesssage) {this.emailMesssage = emailMesssage;}
    public String getAboutMessage() {return aboutMessage;}
    public void setAboutMessage(String aboutMessage) {this.aboutMessage = aboutMessage;}
    public String getContentMessage() {return contentMessage;}
    public void setContentMessage(String contentMessage) {this.contentMessage = contentMessage;}
}
