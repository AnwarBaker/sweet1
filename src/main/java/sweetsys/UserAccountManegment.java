package sweetsys;

public class UserAccountManegment {


     public boolean exist;

    public void UpdateUser(User user){

        try{
            if(user.getUserlevel()==3){
            for(int i = 0; i < SweetProject.users.size(); i++){
                if(SweetProject.users.get(i).getUsername().equalsIgnoreCase(user.getUsername())){
                    SweetProject.users.set(i,user);
                    break;
                }
            }}
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
