package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.models.*;
import sample.views.LogginView;

import java.io.IOException;

public class RegisterController {

    @FXML
    private TextField usernameBox;
    @FXML
    private TextField mailBox;
    @FXML
    private PasswordField passwordBox1;
    @FXML
    private PasswordField passwordBox2;
    @FXML
    private CheckBox GourmandCheck;
    @FXML
    private CheckBox SansGlutenCheck;
    @FXML
    private CheckBox vegetarienCheck;
    @FXML
    private CheckBox sportifCheck;
    @FXML
    private CheckBox HauteCaloriesCheck;
    @FXML
    private Button registerButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Text mauvaisInfo;

    private Stage stage;
    public void init(Stage stage) {

        this.stage = stage;
        cancelButton.setOnAction(event -> retour());
        registerButton.setOnAction(event -> register());

    }

    public void register() {
        if (validName()) {
            if (validMail()) {
                if (!checkExisting()) {
                    if (validPassword()) {
                        ModelListOfRegimes regimes = new ModelListOfRegimes();
                        if (GourmandCheck.isSelected()) regimes.add(ModelRegimeDataBase.getRegimes().get(0));
                        if (SansGlutenCheck.isSelected()) regimes.add(ModelRegimeDataBase.getRegimes().get(1));
                        if (vegetarienCheck.isSelected()) regimes.add(ModelRegimeDataBase.getRegimes().get(2));
                        if (sportifCheck.isSelected()) regimes.add(ModelRegimeDataBase.getRegimes().get(3));
                        if (HauteCaloriesCheck.isSelected()) regimes.add(ModelRegimeDataBase.getRegimes().get(4));
                        User user = new User(usernameBox.getText(),mailBox.getText(),passwordBox1.getText(),new ModelListOfMyRestaurants(),new ModelListOfMyRecommandations(),new ModelListOfMyFriends(),regimes);
                        ModelUserDatabase.getUsers().add(user);
                        retour();
                    }
                }

            }
        }
    }

    private boolean checkExisting() {
        boolean alreadyId = false;
        boolean alreadyMail = false;
        for (User otherUser : ModelUserDatabase.getUsers()) {
                if (usernameBox.getText().equals(otherUser.getUsername())) {
                    alreadyId = true;
                    break;
                }
                if (mailBox.getText().equals(otherUser.getEmail())) {
                    alreadyMail = true;
                    break;
                }

        }
        if (alreadyId) mauvaisInfo.setText("Identidiant déjà utilisé !");
        else if( alreadyMail) mauvaisInfo.setText("E-mail déjà utilisé !");

        return alreadyId || alreadyMail;

    }

    private boolean validPassword() {
        boolean valid = true;
        if (passwordBox1.getText().length() < 3) {
            valid = false;
            mauvaisInfo.setText("Au moins 3 caractères requis pour le mot de passe !");
        }
        else if (!passwordBox1.getText().equals(passwordBox2.getText())) {
            valid = false;
            mauvaisInfo.setText("Les deux mot de passes sont différents !");
        }
        return valid;

    }

    private boolean validMail() {
        boolean valid = true;
        if (!(mailBox.getText().contains("@") && mailBox.getText().length() > 3)) {
            valid = false;
            mauvaisInfo.setText("Entrez une adresse mail valide !");
        }
        return valid;
    }

    private boolean validName() {
        boolean valid = true;
        if (!(usernameBox.getText().length()>2)) {
            valid = false;
            mauvaisInfo.setText("Entrez un identifiant valide !");
        }
        return valid;
    }

    public void retour() {
        FXMLLoader loader = new FXMLLoader();
        LogginController logginController = new LogginController(this.stage);
        loader.setController(logginController);

        try{
            Parent root = loader.load(getClass().getResourceAsStream("/sample/resources/fxml/Loggin.fxml"));
            root.getStylesheets().add(LogginView.CSS_FILE);
            this.stage.setScene(new Scene(root, LogginView.WIDTH, LogginView.HEIGHT));
            logginController.init();
            this.stage.setTitle(LogginView.LABEL);
            this.stage.show();

        } catch (IOException E){
            E.printStackTrace();
        }
    }

}
