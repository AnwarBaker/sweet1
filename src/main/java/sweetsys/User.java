package sweetsys;

public class User {
    String username;
    String pass;
    int userlevel;
    String Email;

    public User(String username,String pass){
        this.username=username;
        this.pass=pass;
    }

    public User(String username,String pass, int userlevel){
        this.username=username;
        this.pass=pass;
        this.userlevel=userlevel;

    }

    public User(String username,String pass, int userlevel,String Email){
        this.username=username;
        this.pass=pass;
        this.userlevel=userlevel;
        this.Email=Email;
    }


    @Override
    public String toString() {
        return "{" +
                "username='" + username + '\'' +
                ", pass='" + pass + '\'' +
                ", userlevel=" + userlevel +
                ", Email='" + Email + '\'' +
                '}';
    }

    public User() {

    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getUserlevel() {
        return userlevel;
    }

    public void setUserlevel(int userlevel) {
        this.userlevel = userlevel;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    public String getUsername() {
        return username;
    }

    public String getPass() {
        return pass;
    }
}
