package sweetsys;

public class StoreOwnerAccountManegment {

private boolean come;
    public boolean isCome() {
        return come;
    }

    public void updateStoreowneraccount(User user){

        if(user.getUserlevel()==2){
            for(int i = 0; i < SweetProject.getUsers().size(); i++){
                if(SweetProject.getUsers().get(i).getUsername().equalsIgnoreCase(user.getUsername())){
                    SweetProject.getUsers().set(i,user);
                    break;
                }
            }}

    }
}
