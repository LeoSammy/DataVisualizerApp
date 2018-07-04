/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datavisualizerapp;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author leo
 */
public class LoginController implements Initializable {

    @FXML
    private JFXTextField usrname;
    @FXML
    private JFXPasswordField pswd;
    @FXML
    private JFXButton lgn;
    @FXML
    private JFXButton signup;
    @FXML
    private Label stats;
    @FXML
    private ImageView image;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void lgnButtonAction(ActionEvent event) {
        //Verification if user is Authenticated rightly
       
    
        System.out.print("Logged in");
    }

    //Function to Launch Signup window
    @FXML
    private void signupButtonAction(ActionEvent event) throws IOException {
        
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("signup.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("signUp window");
        stage.show();
        
        System.out.print("Signing up...");
    }
    
}
