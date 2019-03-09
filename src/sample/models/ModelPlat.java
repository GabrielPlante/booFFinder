package sample.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ModelPlat {

    private StringProperty namePlat;
    private StringProperty prix;
    private StringProperty calories;

    public ModelPlat(String name, int prix, int calories) {
        this.namePlat = new SimpleStringProperty(name) ;
        this.prix = new SimpleStringProperty(String.valueOf(prix));
        this.calories = new SimpleStringProperty(String.valueOf(calories));

    }


    public String getName() {
        return namePlat.get();
    }

    public String getPrix() {
        return prix.get();
    }

    public String getCalories() {
        return calories.get();
    }
}
