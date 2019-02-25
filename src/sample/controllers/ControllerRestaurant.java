package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import sample.models.ModelRestaurant;

public class ControllerRestaurant {

    @FXML
    private Label name;

    public void init(ModelRestaurant restaurant) {
        name.setText(restaurant.getName());
    }
}
