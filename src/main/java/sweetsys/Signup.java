package sweetsys;

public class Signup {



    public boolean in;
    public boolean done;

    public Signup() {

    }


    public boolean isIn() {
        return in;
    }

    public void setIn(boolean in) {
        this.in = in;
    }


User user;




    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }




    public void addnewuser(User user) {
        SweetProject s=new SweetProject();

        boolean exist = s.isValidUser(s.getUsers(), user.getUsername(), user.getPass());

        if (!exist && (user.getUserlevel() == 1 || user.getUserlevel() == 2 || user.getUserlevel() == 3)) {

            String email = user.getUsername() + user.getPass() + "@gmail.com";
            SweetProject.users.add(new User(user.getUsername(), user.getPass(), user.getUserlevel(), email));
            SweetProject.setUsers(SweetProject.users);

        } else {
            System.out.println("User already exists");
        }
    }




    public void addnewuserforuseronly(User user) {
        SweetProject s=new SweetProject();
        boolean exist = s.isValidUser(s.getUsers(), user.getUsername(), user.getPass());
        if (!exist &&user.getUserlevel()==1) {
            String email = user.getUsername() + user.getPass() + "@gmail.com";
            SweetProject.users.add(new User(user.getUsername(), user.getPass(), user.getUserlevel(), email));
            SweetProject.setUsers(SweetProject.users);

        } else {
            System.out.println("User already exists");
        }
    }





}
