package sample.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

public class ModelRestaurant {

    private StringProperty nameRestaurant;
    private ArrayList<ModelPlat> plats;
    private int note;
    private String description;
    private String fileName;

    public ModelRestaurant(String name, int note, ArrayList<ModelPlat> plats, String fileName,String description) {
        this.nameRestaurant = new SimpleStringProperty(name) ;
        this.note = note;
        this.plats = plats;
        this.description = description;
        this.fileName = fileName;
    }

    public String getDescription() {
        if (description.equals("")) return "Aucune description";
        return description;
    }

    public String getUrl() {
        if (fileName.equals("")) return "sample/resources/images/restaurant.jpg";
        return "sample/resources/images/" + fileName;
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
