package org.example.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.models.User;
import org.example.school_manager.HelloApplication;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class AuthController {


    private String file="";

    @FXML
    private TextField emailTextField;

    @FXML
    private PasswordField passwordPasswordTextField;

    @FXML
    void onRegister(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("hello-view - Copie.fxml")));
        Stage stage = (Stage)emailTextField.getScene().getWindow();
        stage.setScene(new Scene(root));


    }

    @FXML
    void onSubmitRegister(ActionEvent event) throws SQLException, IOException {
        String email = emailTextField.getText().trim();
        String password = passwordPasswordTextField.getText().trim();

        if (!email.isEmpty() && !password.isEmpty()){
            User user = new User();
            user.setEmail(email);
            user.setPassword(password);
            user.register(user);
            Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("register-student.fxml")));
            Stage stage = (Stage)emailTextField.getScene().getWindow();
            stage.setScene(new Scene(root));

        }

    }

    @FXML
    void onSignIn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("hello-view.fxml")));
        Stage stage = (Stage)emailTextField.getScene().getWindow();
        stage.setScene(new Scene(root));


    }


    @FXML
    void onSubmitSignIn(ActionEvent event) throws SQLException, IOException {
        String email= emailTextField.getText().trim();
        String password = passwordPasswordTextField.getText().trim();

        if(!email.isEmpty() && !password.isEmpty()){
            User user = new User();
            user.setEmail(email);
            user.setPassword(password);

            boolean result = user.signIn(user);

            if (result){
                Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("register-student.fxml")));
                Stage stage = (Stage)emailTextField.getScene().getWindow();
                stage.setScene(new Scene(root));
            }


        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Echec d'authentification");
            alert.setHeaderText("veuillez remplir tous les champs");

            alert.showAndWait();
        }

    }
    
}
