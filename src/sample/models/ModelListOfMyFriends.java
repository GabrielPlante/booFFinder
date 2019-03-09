package sample.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;


public class ModelListOfMyFriends {

    private ObservableList<ModelFriend> listOfMyFriends;

    public ModelListOfMyFriends() {
        listOfMyFriends = FXCollections.observableList(new ArrayList<>());
        listOfMyFriends.add(new ModelFriend("Maxime09000"));
        listOfMyFriends.add(new ModelFriend("LeKingofTheNorth"));


    }

    public void add(ModelFriend friend) {
        listOfMyFriends.add(friend);
    }

    public ObservableList<ModelFriend> getListOfMyFriends() {
        return listOfMyFriends;
    }

}
