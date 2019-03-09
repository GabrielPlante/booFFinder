package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.models.ModelListOfMyRecommandations;
import sample.models.User;
import sample.models.UserList;
import sample.views.AccueilView;
import javafx.scene.image.Image ;


import java.io.IOException;

public class LogginController {

    private Stage stage;

    @FXML
    private ImageView mainLogoImage;

    @FXML
    private TextField usernameBox;

    @FXML
    private PasswordField passwordBox;

    @FXML
    private Button connectionButton;

    @FXML
    private Label badCredentials;

    @FXML
    private Button createAccountButton;



    public LogginController(Stage stage) {
        this.stage = stage;
    }

    public void init() {
        connectionButton.setOnAction(event -> checkConnection());
        mainLogoImage.setImage(AccueilView.image);
        /**
        badCredentials.setText("");
        this.stage.getScene().setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                checkConnection();
                keyEvent.consume();
            }
        });
         */
        //createAccountButton.setOnAction(event -> openSignUp());
        //FPWLink.setOnAction(event -> openForgotPass());
    }



    private void checkConnection() {
        String username = usernameBox.getCharacters().toString();
        String password = passwordBox.getCharacters().toString();
        openAccueil(UserList.getDatabase().get(0));

        /**
        if (result != null) {
            openMainMenu(result);
        } else {
            showBadCredentialsError();
        }
         **/

    }

    private void showBadCredentialsError() {
        usernameBox.clear();
        passwordBox.clear();
        badCredentials.setText("Réessayez");
    }


    private void openAccueil(User user) {
        FXMLLoader loader = new FXMLLoader();

        //create a controller
        AccueilController controller = new AccueilController(this.stage, user);

        //attach controller
        loader.setController(controller);

        try {
            ModelListOfMyRecommandations modelRecommandations = user.getMyRecommandations();
            Parent root = loader.load(getClass().getResourceAsStream("/sample/resources/fxml/Accueil.fxml"));
            root.getStylesheets().add(AccueilView.CSS_FILE);
            //initialize the controller
            controller.init(modelRecommandations);
            AccueilView.init(modelRecommandations,controller);
            //create the view
            this.stage.setScene(new Scene(root, AccueilView.WIDTH, AccueilView.HEIGHT));
            this.stage.setTitle(AccueilView.LABEL);

            //show the view
            this.stage.show();
        } catch (IOException E) {
            E.printStackTrace();
        }
    }

    /**

    private void openSignUp() {
        FXMLLoader loader = new FXMLLoader();

        //create a controller
        InscriptionController controller = new InscriptionController(this.stage);

        //attach controller
        loader.setController(controller);

        //attach XML file
        try {
            Parent root = loader.load(getClass().getResourceAsStream(InscriptionView.XML_FILE));
            root.getStylesheets().add(InscriptionView.CSS_FILE);
            //initialize the controller

            //create the view

            this.stage.setScene(new Scene(root, InscriptionView.WIDTH, InscriptionView.HEIGHT));
            controller.init();
            this.stage.setTitle(InscriptionView.LABEL);

            //show the view
            this.stage.show();
        } catch (IOException E) {
            E.printStackTrace();
        }
    }

    private void openForgotPass() {
        FXMLLoader loader = new FXMLLoader();

        //create a controller
        ForgetPasswordController forgetPasswordController = new ForgetPasswordController(this.stage);

        //attach controller
        loader.setController(motDePasseOublierController);

        //attach XML file
        try {
            Parent root = loader.load(getClass().getResourceAsStream(MDPOublierView.XML_FILE));
            root.getStylesheets().add(MDPOublierView.CSS_FILE);

            this.stage.setScene(new Scene(root, MDPOublierView.WIDTH, MDPOublierView.HEIGHT));
            motDePasseOublierController.init();
            this.stage.setTitle(MDPOublierView.LABEL);

            //show the view
            this.stage.show();
        } catch (IOException E) {
            E.printStackTrace();
        }
    }
     **/
}
