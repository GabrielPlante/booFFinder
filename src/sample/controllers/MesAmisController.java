package sample.controllers;

import javafx.fxml.FXML;
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
        mainLogoImage.setImage(AccueilView.image);

        voirFriendButton.setOnAction(event -> openFriendPage());


        addFriendButton.setOnAction( event -> {
            modelListOfMyFriends.add( new ModelPerson(friendNameField.getText(),new ArrayList<>(), new ArrayList<>()));
        });

        removeFriendButton.setOnAction( event -> {
            modelListOfMyFriends.getListOfMyFriends().remove( MesFriendsView.getRangeSelectedItemFriend() );
        });



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



}
