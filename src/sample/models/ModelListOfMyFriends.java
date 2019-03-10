package sample.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;


public class ModelListOfMyFriends {

    private ObservableList<User> listOfMyFriends;

    public ModelListOfMyFriends() {
        listOfMyFriends = FXCollections.observableList(new ArrayList<>());
    }

    public void add(User friend) {
        listOfMyFriends.add(friend);
    }

    public void remove(User friend) {
        listOfMyFriends.remove(friend);
    }

    public ObservableList<User> getListOfMyFriends() {
        return listOfMyFriends;
    }

}
