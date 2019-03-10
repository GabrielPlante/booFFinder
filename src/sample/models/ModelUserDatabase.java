package sample.models;

import javafx.collections.FXCollections;

import java.util.ArrayList;

public class ModelUserDatabase {


    private static ArrayList<User> users;

    public ModelUserDatabase(ModelRestaurantDataBase restaurantDataBase, ModelRegimeDataBase regimeDataBase) {

        ModelUserDatabase.users = new ArrayList<>();

        ModelListOfMyRecommandations recommandations1 = new ModelListOfMyRecommandations();
        ModelListOfMyFriends friends1 = new ModelListOfMyFriends();
        ModelListOfMyRestaurants restaurants1 = new ModelListOfMyRestaurants();
        ModelListOfRegimes regimes1 =  new ModelListOfRegimes();

        ModelListOfMyRecommandations recommandations2 = new ModelListOfMyRecommandations();
        ModelListOfMyFriends friends2 = new ModelListOfMyFriends();
        ModelListOfMyRestaurants restaurants2 = new ModelListOfMyRestaurants();
        ModelListOfRegimes regimes2 =  new ModelListOfRegimes();

        ModelListOfMyRecommandations recommandations3 = new ModelListOfMyRecommandations();
        ModelListOfMyFriends friends3 = new ModelListOfMyFriends();
        ModelListOfMyRestaurants restaurants3 = new ModelListOfMyRestaurants();
        ModelListOfRegimes regimes3 =  new ModelListOfRegimes();

        ModelListOfMyRecommandations recommandations4 = new ModelListOfMyRecommandations();
        ModelListOfMyFriends friends4 = new ModelListOfMyFriends();
        ModelListOfMyRestaurants restaurants4 = new ModelListOfMyRestaurants();
        ModelListOfRegimes regimes4 =  new ModelListOfRegimes();

        ModelListOfMyRecommandations recommandations5 = new ModelListOfMyRecommandations();
        ModelListOfMyFriends friends5 = new ModelListOfMyFriends();
        ModelListOfMyRestaurants restaurants5 = new ModelListOfMyRestaurants();
        ModelListOfRegimes regimes5 =  new ModelListOfRegimes();

        restaurants1.add(restaurantDataBase.getRestaurants().get(0));
        restaurants1.add(restaurantDataBase.getRestaurants().get(2));
        restaurants2.add(restaurantDataBase.getRestaurants().get(4));
        restaurants2.add(restaurantDataBase.getRestaurants().get(3));
        restaurants3.add(restaurantDataBase.getRestaurants().get(4));
        restaurants3.add(restaurantDataBase.getRestaurants().get(1));
        restaurants3.add(restaurantDataBase.getRestaurants().get(2));
        restaurants4.add(restaurantDataBase.getRestaurants().get(1));
        restaurants4.add(restaurantDataBase.getRestaurants().get(2));
        restaurants5.add(restaurantDataBase.getRestaurants().get(4));

        regimes1.add(regimeDataBase.getRegimes().get(0));
        regimes1.add(regimeDataBase.getRegimes().get(4));
        regimes2.add(regimeDataBase.getRegimes().get(1));
        regimes2.add(regimeDataBase.getRegimes().get(2));
        regimes3.add(regimeDataBase.getRegimes().get(2));
        regimes3.add(regimeDataBase.getRegimes().get(3));
        regimes4.add(regimeDataBase.getRegimes().get(1));
        regimes4.add(regimeDataBase.getRegimes().get(0));
        regimes4.add(regimeDataBase.getRegimes().get(4));
        regimes4.add(regimeDataBase.getRegimes().get(0));

        User user1 = new User("Max","max@orange.fr","123",restaurants1,recommandations1,friends1,regimes1);
        User user2 = new User("Bob3","bob3@orange.fr","abc",restaurants2,recommandations2,friends2,regimes2);
        User user3 = new User("GiléJauné","gilejaune@orange.fr","ef6",restaurants3,recommandations3,friends3,regimes3);
        User user4 = new User("Damien","damien@orange.fr","dam8",restaurants4,recommandations4,friends4,regimes4);
        User user5 = new User("Rocky","rocky@orange.fr","rock7",restaurants5,recommandations5,friends5,regimes5);

        user1.getMyFriends().add(user2);
        user1.getMyFriends().add(user3);
        user2.getMyFriends().add(user1);
        user2.getMyFriends().add(user3);
        user3.getMyFriends().add(user1);
        user3.getMyFriends().add(user2);
        user3.getMyFriends().add(user4);
        user4.getMyFriends().add(user1);
        user4.getMyFriends().add(user5);
        user4.getMyFriends().add(user2);
        user5.getMyFriends().add(user1);
        user5.getMyFriends().add(user4);

        user1.updateRecommandations();
        user2.updateRecommandations();
        user3.updateRecommandations();
        user4.updateRecommandations();
        user5.updateRecommandations();

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);

    }

    public static ArrayList<User> getUsers() {
        return users;
    }
}
