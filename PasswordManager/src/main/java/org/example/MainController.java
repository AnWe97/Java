package org.example;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLOutput;

public class MainController {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField confirmPassword;
    @FXML
    private Label errorLabel;

    private User currentUser;



    @FXML
    private void createAccountButton(ActionEvent event) throws IOException{
        String usernameInput = username.getText();
        String passwordInput = password.getText();
        String confirmedPasswordInput = confirmPassword.getText();

        if(password.getText().equals(confirmPassword.getText())){
            currentUser = new User(usernameInput, passwordInput);
            switchToLogin(event, currentUser);
        }else{
            errorLabel.setText("Passwords are different.");
        }

    }

    @FXML
    private void loginButton(ActionEvent event, User currentUser) throws IOException{
        String usernameInput = username.getText();
        String passwordInput = password.getText();

        if(currentUser.getUsername().equals(usernameInput) && currentUser.getPassword().equals(passwordInput)){
            switchToManagement(event, currentUser);
        }else{
            errorLabel.setText("Wrong Password or Username");
        }
    }

    public void switchToLogin (ActionEvent event, User currentUser) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/org/example/login.fxml"));
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void switchToManagement (ActionEvent event, User currentUser) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/org/example/management.fxml"));
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


}
