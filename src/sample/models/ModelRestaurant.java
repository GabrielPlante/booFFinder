package sample.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

public class ModelRestaurant {

    private StringProperty nameRestaurant;
    private ArrayList<ModelPlat> plats;
    private int note;

    public ModelRestaurant(String name, int note, ArrayList<ModelPlat> plats) {
        this.nameRestaurant = new SimpleStringProperty(name) ;
        this.note = note;
        this.plats = plats;
    }


    public String getName() {
        return nameRestaurant.get();
    }

    public int getNote() {
        return note;
    }

    public ArrayList<ModelPlat> getPlats() {
        return plats;
    }
}
