package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import sample.models.ModelPerson;

public class ControllerFriend {

    @FXML
    private Label nameFriend;

    public void init(ModelPerson friend) {
        nameFriend.setText(friend.getName());
    }
}
