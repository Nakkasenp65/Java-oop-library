package testlibrary;

public class User {

    private int userID;
    private String username;
    private String password;
    private String emailAddress;
    private String role = "User";



    public User(int userID, String username, String password, String emailAddress) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.emailAddress = emailAddress;
    }
    
    public User(int userID, String username, String password, String emailAddress,String role){
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.emailAddress = emailAddress;
        this.role = role;
    }

    public String getUserDetails() {
        String userID = "User ID:" + getUserID() + "\n";
        String userName = "Username: " + getUsername() + "\n";
        String emailAddress = "Email: " + getEmailAddress() + "\n";
        String role = "Role: " + getRole() + "\n";
        return userID + userName + emailAddress + role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
