package sample.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;


public class ModelListOfMyRecommandations {

    private ObservableList<ModelRestaurant> listOfMyRestaurants;

    public ModelListOfMyRecommandations() {

        ModelPlat pates = new ModelPlat("Poulet",10,1000);

        ArrayList<ModelPlat> plats1 = new ArrayList<>();


        plats1.add(pates);

        listOfMyRestaurants = FXCollections.observableList(new ArrayList<>());
        listOfMyRestaurants.add(new ModelRestaurant("Quick",4,plats1,"quick.jpg","Le poulet c'est bon"));



    }

    public void add(ModelRestaurant restaurant) {
        listOfMyRestaurants.add(restaurant);
    }
    public void remove(ModelRestaurant restaurant) {listOfMyRestaurants.remove(restaurant);}

    public ObservableList<ModelRestaurant> getListOfMyRestaurants() {
        return listOfMyRestaurants;
    }

}
