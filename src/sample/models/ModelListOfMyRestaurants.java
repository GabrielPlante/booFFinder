package sample.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;


public class ModelListOfMyRestaurants {

    private ObservableList<ModelRestaurant> listOfMyRestaurants;

    public ModelListOfMyRestaurants() {

        listOfMyRestaurants = FXCollections.observableList(new ArrayList<>());

    }

    public void add(ModelRestaurant restaurant) {
        listOfMyRestaurants.add(restaurant);
    }

    public void remove(ModelRestaurant restaurant) {
        listOfMyRestaurants.remove(restaurant);
    }

    public ObservableList<ModelRestaurant> getListOfMyRestaurants() {
        return listOfMyRestaurants;
    }

}
