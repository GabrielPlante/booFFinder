package sample.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ModelPlat {

    private StringProperty namePlat;
    private int prix;
    private int calories;

    public ModelPlat(String name, int prix, int calories) {
        this.namePlat = new SimpleStringProperty(name) ;
        this.prix = prix;
        this.calories = calories;

    }


    public String getName() {
        return namePlat.get();
    }

    public int getPrix() {
        return prix;
    }

    public int getCalories() {
        return calories;
    }
}
