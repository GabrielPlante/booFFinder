package sample.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ModelRestaurant {

    private StringProperty name;

    public ModelRestaurant(String name) {
        this.name = new SimpleStringProperty(name) ;
    }


    public String getName() {
        return name.get();
    }

}
