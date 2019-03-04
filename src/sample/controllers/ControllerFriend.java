package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import sample.models.ModelFriend;

public class ControllerFriend {

    @FXML
    private Label nameFriend;

    public void init(ModelFriend friend) {
        nameFriend.setText(friend.getName());
    }
}
