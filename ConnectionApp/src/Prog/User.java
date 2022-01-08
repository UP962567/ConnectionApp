package Prog;

public class User {
    private String time;
    private String username;
    private String message;


    public User(String time, String username, String message){
        this.time = time;
        this.username = username;
        this.message = message;

    }

    public String getTime(){ return time; }
    public String getUsername(){ return username; }
    public String getMessage(){ return message; }

}
