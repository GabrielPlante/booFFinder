package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import sample.models.ModelListOfMyRestaurants;
import sample.models.ModelRestaurant;

import javax.swing.text.html.ListView;


public class ControllerRecommandation {

    @FXML
    private AnchorPane fond;
    @FXML
    private Circle cercle;
    @FXML
    private Text nameRestaurant;
    @FXML
    private Text descriptionRestaurant;

    public void init(ModelRestaurant restaurant) {
        nameRestaurant.setText(restaurant.getName());
        descriptionRestaurant.setText(restaurant.getDescription());
        fond.setBackground(Background.EMPTY);
        cercle.setFill(new ImagePattern(new Image(restaurant.getUrl())));
    }


}
