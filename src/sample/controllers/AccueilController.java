package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.models.ModelListOfMyRecommandations;
import sample.models.ModelListOfMyRestaurants;
import sample.models.PageLoader;
import sample.models.User;
import sample.views.AccueilView;


public class AccueilController {

    private ModelListOfMyRecommandations modelListOfMyRecommandations = null;

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
    private ImageView mainLogoImage;

    @FXML
    private ListView recommandationsListView;
    @FXML
    private Button voirRestaurant;
    @FXML
    private Button ajouterRestaurant;


    private Stage stage;
    private User user;
    private PageLoader pg;

    public AccueilController(Stage stage, User user) {
        this.stage = stage;
        this.user = user;
        this.pg = new PageLoader(stage, user);

    }

    public ListView getMyRestaurantsListView() {
        return recommandationsListView;
    }

    public void init(ModelListOfMyRecommandations recommandations) {

        modelListOfMyRecommandations = recommandations;

        main_menu_accueil.setOnAction(event -> openAccueil());
        main_menu_mesRestos.setOnAction(event -> openMesRestos());
        main_menu_mesAmis.setOnAction(event -> openMesAmis());
        main_menu_parametres.setOnAction(event -> openParametres());
        mainLogoImage.setImage(AccueilView.image);



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
