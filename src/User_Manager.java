package sample;

import java.util.ArrayList;
import java.util.Iterator;

public class User_Manager {

    private ArrayList<User> userList = new ArrayList<User>();


    public void new_user(String username, String password, String type) {

    }

    public void delete_user(String username) {

    }

    public void edit_user(String username, String password, String type) {

    }

    public boolean search_user(String username) {
        return false;
    }

    public User_Manager() {
        User user = new User("user", "user", 5);
        User adm = new User("admin", "admin", 4);
        userList.add(adm);
        userList.add(user);
    }

    public int authenticate(String name, String password) {
        Iterator<User> itr = userList.iterator();

        while(itr.hasNext()){
            User aux = itr.next();
            if(aux.getNomeDeUsuario().equals(name)){
                if(aux.getSenha().equals(password)){
                    return aux.getAcesso();
                }
                else
                    return 3;
            }
        }
        return 2;
    }


}

