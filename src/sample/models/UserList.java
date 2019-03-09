package sample.models;

import java.util.ArrayList;

public class UserList {

    private static ArrayList<User> database =new ArrayList<User>(){{
        add(new User("Julie","juliev@gmail.com","12"));
        add(new User("Bruno","brunoinshape@gmail.com","10"));
    }};

    public static ArrayList<User> getDatabase(){
        return database;
    }


}
