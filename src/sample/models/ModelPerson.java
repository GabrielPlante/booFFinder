package sample.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

public class ModelPerson {

    private StringProperty namePerson;
    private ArrayList<ModelRestaurant> modelRestaurants;
    private ArrayList<ModelRegime> regimes;

    public ModelPerson(String name, ArrayList<ModelRestaurant> restaurants, ArrayList<ModelRegime> regimes) {
        this.namePerson = new SimpleStringProperty(name) ;
        modelRestaurants = restaurants;
        this.regimes = regimes;

    }


    public String getName() {
        return namePerson.get();
    }

    public ArrayList<ModelRestaurant> getModelRestaurants() {
        return modelRestaurants;
    }

    public ArrayList<ModelRegime> getRegimes() {
        return regimes;
    }
}
