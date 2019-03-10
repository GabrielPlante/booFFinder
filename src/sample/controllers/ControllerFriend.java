package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import sample.models.User;

public class ControllerFriend {

    @FXML
    private Label name;

    public void init(User friend) {
        name.setText(friend.getUsername());
    }
}
