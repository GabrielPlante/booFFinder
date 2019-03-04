package sample.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ModelFriend {

    private StringProperty nameFriend;

    public ModelFriend(String name) {
        this.nameFriend = new SimpleStringProperty(name) ;
    }


    public String getName() {
        return nameFriend.get();
    }

}
