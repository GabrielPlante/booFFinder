package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sample.models.*;
import sample.views.AccueilView;

import java.util.ArrayList;
import java.util.Optional;

public class ParametresController {
    @FXML
    private ImageView mainLogoImage;

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
    private TextField identifiantInfo;

    @FXML
    private TextField emailInfo;

    @FXML
    private PasswordField motDePasseInfo;

    @FXML
    private Button modifierInfos;

    @FXML
    private CheckBox GourmandCheck;

    @FXML
    private CheckBox vegetarienCheck;
    @FXML
    private CheckBox SansGlutenCheck;
    @FXML
    private CheckBox sportifCheck;
    @FXML
    private CheckBox HauteCaloriesCheck;
    @FXML
    private Button main_menu_deco;



    private Stage stage;
    private User user;
    private PageLoader pg;

    public ParametresController(Stage stage, User user) {
        this.stage = stage;
        this.user = user;
        this.pg = new PageLoader(stage, user);

    }

    public void init() {

        main_menu_accueil.setOnAction(event -> openAccueil());
        main_menu_mesRestos.setOnAction(event -> openMesRestos());
        main_menu_mesAmis.setOnAction(event -> openMesAmis());
        main_menu_parametres.setOnAction(event -> openParametres());
        main_menu_deco.setOnAction(event -> openLoggin());
        modifierInfos.setOnAction(event -> modifier());
        mainLogoImage.setImage(AccueilView.image);
        initInfos();

    }

    private void initInfos() {
        identifiantInfo.setText(user.getUsername());
        emailInfo.setText(user.getEmail());
        GourmandCheck.setSelected(user.getMyRegimes().getRegimes().contains(ModelRegimeDataBase.getRegimes().get(0)));
        SansGlutenCheck.setSelected(user.getMyRegimes().getRegimes().contains(ModelRegimeDataBase.getRegimes().get(1)));
        vegetarienCheck.setSelected(user.getMyRegimes().getRegimes().contains(ModelRegimeDataBase.getRegimes().get(2)));
        sportifCheck.setSelected(user.getMyRegimes().getRegimes().contains(ModelRegimeDataBase.getRegimes().get(3)));
        HauteCaloriesCheck.setSelected(user.getMyRegimes().getRegimes().contains(ModelRegimeDataBase.getRegimes().get(4)));
    }

    private void modifier() {
        boolean exist = checkExisting();
        if(!exist) {
            Dialog dialog = new TextInputDialog("");
            dialog.setTitle("Confirmation");
            dialog.setHeaderText("Entrez votre mot de passe actuel");

            Optional<String> result = dialog.showAndWait();
            String entered = "";

            if (result.isPresent()) {
                entered = result.get();
            }

            if (user.getPassword().equals(entered)) {validModif();}
            else badMDP();
        }

        pg.openParametres();



    }

    private void badMDP() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Mauvais mot de passe");
        alert.setHeaderText("Erreur dans la saisie du mot de passe");
        alert.show();
    }

    private boolean checkExisting() {
        boolean alreadyId = false;
        boolean alreadyMail = false;
        for (User otherUser : ModelUserDatabase.getUsers()) {
            if (!user.getUsername().equals(otherUser.getUsername())) {
                if (identifiantInfo.getText().equals(otherUser.getUsername())) {
                    alreadyId = true;
                    break;
                }
                if (emailInfo.getText().equals(otherUser.getEmail())) {
                    alreadyMail = true;
                    break;
                }
            }
        }
        if (alreadyId) alreadyExist("Cet identifiant est déjà utilisé");
        else if( alreadyMail) alreadyExist("Cette adresse mail est déjà utilisée");
        else validModif();

        return alreadyId || alreadyMail;

    }

    private void alreadyExist(String text) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Impossible de modifier ces informations");
        alert.setHeaderText("Erreur sur la modification des données");
        alert.setContentText(text);
        alert.show();
    }

    private void validModif() {

        ArrayList<ModelRegime> regimes = new ArrayList<>();
        if (GourmandCheck.isSelected()) regimes.add(ModelRegimeDataBase.getRegimes().get(0));
        if (SansGlutenCheck.isSelected()) regimes.add(ModelRegimeDataBase.getRegimes().get(1));
        if (vegetarienCheck.isSelected()) regimes.add(ModelRegimeDataBase.getRegimes().get(2));
        if (sportifCheck.isSelected()) regimes.add(ModelRegimeDataBase.getRegimes().get(3));
        if (HauteCaloriesCheck.isSelected()) regimes.add(ModelRegimeDataBase.getRegimes().get(4));
        String mdp = user.getPassword();
        if (!motDePasseInfo.getText().equals("")) mdp = motDePasseInfo.getText();
        user.updateInfos(identifiantInfo.getText(),emailInfo.getText(),mdp,regimes);
        user.updateRecommandations();
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
