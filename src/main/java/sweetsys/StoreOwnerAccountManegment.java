package sweetsys;

public class StoreOwnerAccountManegment {

private boolean come;
    public boolean isCome() {
        return come;
    }

    public void UpdateStoreOwnerAccount(User user){


            if(user.getUserlevel()==2){
            for(int i = 0; i < SweetProject.users.size(); i++){
                if(SweetProject.users.get(i).getUsername().equalsIgnoreCase(user.getUsername())){
                    SweetProject.users.set(i,user);
                    break;
                }
            }}

    }
}
