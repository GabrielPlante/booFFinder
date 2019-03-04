package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import sample.ViewMenu;
import sample.models.ModelFriend;
import sample.models.ModelListOfMyFriends;
import sample.models.ModelListOfMyRestaurants;


public class ControllerMenu {
    private ModelListOfMyRestaurants modelListOfMyRestaurants = null;
    private ModelListOfMyFriends modelListOfMyFriends = null;

    private ViewMenu view;

    @FXML
    private ListView myRestaurantsListView;
    @FXML
    private ListView myFriendsListView;
    @FXML
    private TextField friendNameField;
    @FXML
    private Button addFriendButton;
    @FXML
    private Button removeFriendButton;



    public ListView getMyRestaurantsListView() {
        return myRestaurantsListView;
    }

    public ListView getMyFriendsListView() {
        return myFriendsListView;
    }


    public TextField getFriendNameField() {
        return friendNameField;
    }

    public void init(ModelListOfMyRestaurants myRestaurantsList, ModelListOfMyFriends myFriendsList, ViewMenu view) {
        this.modelListOfMyRestaurants = myRestaurantsList;
        this.modelListOfMyFriends = myFriendsList;

        addFriendButton.setOnAction( event -> {
            modelListOfMyFriends.add( new ModelFriend(friendNameField.getText()));
        });

        removeFriendButton.setOnAction( event -> {
            modelListOfMyFriends.getListOfMyFriends().remove( view.getRangeSelectedItemFriend() );
        });
    }

}
