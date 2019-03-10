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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.models.ModelListOfMyRecommandations;
import sample.models.ModelRestaurantDataBase;
import sample.models.ModelUserDatabase;
import sample.models.User;
import sample.views.AccueilView;
import sample.views.RegisterView;


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
    private Text mauvaisPassword;

    @FXML
    private Button registerButton;






    public LogginController(Stage stage) {
        this.stage = stage;
    }

    public void init() {
        connectionButton.setOnAction(event -> checkConnection());
        registerButton.setOnAction(event -> openRegister());
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
        User mainUser = null;
        for (User user : ModelUserDatabase.getUsers()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                mainUser = user;
                break;
            }
        }
        if (mainUser!=null) {
            openAccueil(mainUser);
        }
        else {
            showBadCredentialsError();
        }

    }

    private void showBadCredentialsError() {
        usernameBox.clear();
        passwordBox.clear();
        mauvaisPassword.setText("Mauvais mot de passe !");
    }


    private void openAccueil(User user) {

        user.updateRecommandations();
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

    private void openRegister() {
        FXMLLoader loader = new FXMLLoader();

        //create a controller
        RegisterController controller = new RegisterController();

        //attach controller
        loader.setController(controller);

        try {
            Parent root = loader.load(getClass().getResourceAsStream("/sample/resources/fxml/Register.fxml"));
            root.getStylesheets().add(AccueilView.CSS_FILE);
            //initialize the controller
            controller.init(stage);
            //create the view
            this.stage.setScene(new Scene(root, RegisterView.WIDTH, RegisterView.HEIGHT));
            this.stage.setTitle(AccueilView.LABEL);

            //show the view
            this.stage.show();
        } catch (IOException E) {
            E.printStackTrace();
        }
    }
}
