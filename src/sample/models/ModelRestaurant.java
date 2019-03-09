package sample.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ModelRestaurant {

    private StringProperty nameRestaurant;
    private int note;

    public ModelRestaurant(String name, int note) {
        this.nameRestaurant = new SimpleStringProperty(name) ;
        this.note = note;
    }


    public String getName() {
        return nameRestaurant.get();
    }

}
