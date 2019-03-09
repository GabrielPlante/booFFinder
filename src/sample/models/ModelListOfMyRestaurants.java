package sample.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;


public class ModelListOfMyRestaurants {

    private ObservableList<ModelRestaurant> listOfMyRestaurants;

    public ModelListOfMyRestaurants() {

        ModelPlat pates = new ModelPlat("Pâtes",10,100);
        ModelPlat steak = new ModelPlat("Steak Frite",12,400);

        ArrayList<ModelPlat> plats1 = new ArrayList<>();
        ArrayList<ModelPlat> plats2 = new ArrayList<>();

        plats1.add(pates);
        plats1.add(steak);
        plats2.add(steak);

        listOfMyRestaurants = FXCollections.observableList(new ArrayList<>());
        listOfMyRestaurants.add(new ModelRestaurant("MacDonald",4,plats1,"macdo.png","I'm Lovin' It"));
        listOfMyRestaurants.add(new ModelRestaurant("KFC",3,plats2,"KFC.png","It's finger lickin' good"));


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
