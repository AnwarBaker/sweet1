package sweetsys;

public class User {
    String username;
    String pass;
    int userlevel;

    public User(String username,String pass){
        this.username=username;
        this.pass=pass;
    }
    public User(String username,String pass, int userlevel){
        this.username=username;
        this.pass=pass;
        this.userlevel=userlevel;
    }


    @Override
    public String toString() {
        return "Name='" + username+ "', Pass='" + pass+"' ,UserLevel='"+userlevel+"'"  ;
    }

    public User() {

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
