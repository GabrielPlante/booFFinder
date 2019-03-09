package sample.models;

public class User {

    private String username;
    private String email;
    private String password;
    private ModelListOfMyRestaurants myRestaurants;
    private ModelListOfMyRecommandations myRecommandations;
    private ModelListOfMyFriends myFriends;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        myRestaurants = new ModelListOfMyRestaurants();
        myRecommandations = new ModelListOfMyRecommandations();
        myFriends = new ModelListOfMyFriends();
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public ModelListOfMyRestaurants getMyRestaurants() {
        return myRestaurants;
    }

    public ModelListOfMyRecommandations getMyRecommandations() {
        return myRecommandations;
    }

    public ModelListOfMyFriends getMyFriends() {
        return myFriends;
    }
}
