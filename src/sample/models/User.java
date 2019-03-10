package sample.models;

import java.util.ArrayList;

public class User {

    private String namePerson;
    private String email;
    private String password;

    private ModelListOfMyRestaurants myRestaurants;
    private ModelListOfMyRecommandations myRecommandations;
    private ModelListOfMyFriends myFriends;
    private ModelListOfRegimes myRegimes;

    public User(String name, String email, String password, ModelListOfMyRestaurants restaurants, ModelListOfMyRecommandations recommandations, ModelListOfMyFriends friends, ModelListOfRegimes regimes) {
        namePerson = name;

        this.email = email;
        this.password = password;
        myRestaurants = restaurants;
        myRecommandations = recommandations;
        myFriends = friends;
        myRegimes = regimes;
    }

    public void updateInfos(String name, String email, String password, ArrayList<ModelRegime> newRegimes) {
        namePerson = name;
        this.email = email;
        this.password = password;
        myRegimes.getRegimes().clear();
        for(ModelRegime regime : newRegimes) {
            myRegimes.add(regime);
        }

    }

    public String getUsername() {
        return namePerson;
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

    public void updateRecommandations() {

        myRecommandations.getListOfMyRestaurants().clear();


        for(ModelRestaurant restaurant : ModelRestaurantDataBase.getRestaurants()) {

            boolean addNext = true;
            if (!myRestaurants.getListOfMyRestaurants().contains(restaurant)) {
                for (ModelRegime regime : restaurant.getRegimes().getRegimes()) {
                    if (myRegimes.getRegimes().contains(regime) && addNext) {
                        myRecommandations.add(restaurant);
                        addNext = false;
                    }

                }
            }
        }

    }

    public ModelListOfRegimes getMyRegimes() {
        return myRegimes;
    }
}
