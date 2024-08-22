package sweetsys;

import java.util.logging.Logger;
import java.util.logging.Level;

public class Signup {

    private static final Logger logger = Logger.getLogger(Signup.class.getName());

    public static final boolean IN=false;

    public Signup() {
        // Constructor
    }



    public void addnewuser(User user) {
        SweetProject s = new SweetProject();

        boolean exist = s.isValidUser(SweetProject.getUsers(), user.getUsername(), user.getPass());

        if (!exist && (user.getUserlevel() == 1 || user.getUserlevel() == 2 || user.getUserlevel() == 3)) {
            String email = user.getUsername() + user.getPass() + "@gmail.com";
            SweetProject.users.add(new User(user.getUsername(), user.getPass(), user.getUserlevel(), email));
            SweetProject.setUsers(SweetProject.users);
        } else {
            logger.log(Level.WARNING, "User already exists");
        }
    }

    public void addnewuserforuseronly(User user) {
        SweetProject s = new SweetProject();
        boolean exist = s.isValidUser(SweetProject.getUsers(), user.getUsername(), user.getPass());

        if (!exist && user.getUserlevel() == 1) {
            String email = user.getUsername() + user.getPass() + "@gmail.com";
            SweetProject.users.add(new User(user.getUsername(), user.getPass(), user.getUserlevel(), email));
            SweetProject.setUsers(SweetProject.users);
        } else {
            logger.log(Level.WARNING, "User already exists");
        }
    }
}
