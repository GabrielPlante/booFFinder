package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.models.*;
import sample.views.AccueilView;
import sample.views.MesFriendsView;

import java.util.ArrayList;

public class MesAmisController {

    private ModelListOfMyFriends modelListOfMyFriends = null;

    @FXML
    private Button main_menu_accueil;

    @FXML
    private Button main_menu_mesRestos;

    @FXML
    private Button main_menu_mesAmis;

    @FXML
    private Button main_menu_mesRecommandations;

    @FXML
    private Button main_menu_parametres;

    @FXML
    private ListView myFriendsListView;

    @FXML
    private TextField friendNameField;

    @FXML
    private Button addFriendButton;

    @FXML
    private Button removeFriendButton;
    @FXML
    private ImageView mainLogoImage;

    @FXML
    private Button voirFriendButton;
    @FXML
    private Button main_menu_deco;


    private Stage stage;
    private User user;
    private PageLoader pg;

    public MesAmisController(Stage stage, User user) {
        this.stage = stage;
        this.user = user;
        this.pg = new PageLoader(stage, user);

    }

    public void init(ModelListOfMyFriends myFriendsList) {


        this.modelListOfMyFriends= myFriendsList;
        main_menu_accueil.setOnAction(event -> openAccueil());
        main_menu_mesRestos.setOnAction(event -> openMesRestos());
        main_menu_mesAmis.setOnAction(event -> openMesAmis());
        main_menu_parametres.setOnAction(event -> openParametres());
        main_menu_deco.setOnAction(event -> openLoggin());
        mainLogoImage.setImage(AccueilView.image);

        voirFriendButton.setOnAction(event -> openFriendPage());


        addFriendButton.setOnAction( event -> addFriendEvent());

        removeFriendButton.setOnAction( event -> {
            modelListOfMyFriends.getListOfMyFriends().remove( MesFriendsView.getRangeSelectedItemFriend() );
        });



    }

    private void addFriendEvent() {
        User newFriend = null;
        for (User otherUser : ModelUserDatabase.getUsers()) {
            if (!user.equals(otherUser)) {
                if (otherUser.getUsername().equals(friendNameField.getText())) {
                    newFriend = otherUser;
                    break;
                }
            }
        }
        if (newFriend != null) {
            if (user.getMyFriends().getListOfMyFriends().contains(newFriend)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Déjà en amis");
                alert.setHeaderText("Utilisateur déjà en amis !");
                alert.show();
            }
            else {
                modelListOfMyFriends.add(newFriend);
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Aucun utilisateur avec cet identifiant");
            alert.setHeaderText("Utilisateur non trouvé");
            alert.show();
        }
    }


    private void openFriendPage() {
        pg.openMesAmisPage(modelListOfMyFriends.getListOfMyFriends().get(MesFriendsView.getRangeSelectedItemFriend()));
    }

    public ListView getMyFriendsListView() {
        return myFriendsListView;
    }

    private void openAccueil() {
        pg.openAccueil();
    }
    private void openMesRestos() {
        pg.openMesRestos();
    }
    private void openMesAmis() {
        pg.openMesAmis();
    }
    private void openParametres() {pg.openParametres();}
    private void openLoggin() {
        pg.openLoggin();
    }



}
