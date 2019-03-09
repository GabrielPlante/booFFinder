package sample.models;

public class User {

    private String username;
    private String email;
    private String password;
    private ModelListOfMyRestaurants myRestaurants;
    private ModelListOfMyRecommandations myRecommandations;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        myRestaurants = new ModelListOfMyRestaurants();
        myRecommandations = new ModelListOfMyRecommandations();
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
}
