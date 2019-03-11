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
    private String adresse;
    private ModelListOfRegimes regimes;

    public ModelRestaurant(String name, int note, ArrayList<ModelPlat> plats, String fileName,String description, ModelListOfRegimes regimes, String adresse) {
        this.nameRestaurant = new SimpleStringProperty(name) ;
        this.note = note;
        this.plats = plats;
        this.description = description;
        this.fileName = fileName;
        this.regimes = regimes;
        this.description = description;
        this.adresse = adresse;
    }

    public String getAdresse() {
        return adresse;
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

    public ModelListOfRegimes getRegimes() {
        return regimes;
    }
}
