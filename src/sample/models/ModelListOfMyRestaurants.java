package sample.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;


public class ModelListOfMyRestaurants {

    private ObservableList<ModelRestaurant> listOfMyRestaurants;

    public ModelListOfMyRestaurants() {
        listOfMyRestaurants = FXCollections.observableList(new ArrayList<>());
        listOfMyRestaurants.add(new ModelRestaurant("MacDonald",4));
        listOfMyRestaurants.add(new ModelRestaurant("KFC",3));


    }

    public void add(ModelRestaurant restaurant) {
        listOfMyRestaurants.add(restaurant);
    }

    public ObservableList<ModelRestaurant> getListOfMyRestaurants() {
        return listOfMyRestaurants;
    }

}
