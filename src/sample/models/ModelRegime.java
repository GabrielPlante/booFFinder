package sample.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ModelRegime {
    private StringProperty name;

    public ModelRegime(String name) {
        this.name = new SimpleStringProperty(name) ;

    }

    public String getName() {
        return name.get();
    }

}
