package sweetsys;

public class UserAccountManegment {

     public boolean exist;

    public void updateUser(User user){


            if(user.getUserlevel()==3){
            for(int i = 0; i < SweetProject.users.size(); i++){
                if(SweetProject.users.get(i).getUsername().equalsIgnoreCase(user.getUsername())){
                    SweetProject.users.set(i,user);
                    break;
                }
            }}

    }

}
