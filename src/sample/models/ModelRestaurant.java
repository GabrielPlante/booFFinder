package sample.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ModelRestaurant {

    private StringProperty nameRestaurant;

    public ModelRestaurant(String name) {
        this.nameRestaurant = new SimpleStringProperty(name) ;
    }


    public String getName() {
        return nameRestaurant.get();
    }

}
