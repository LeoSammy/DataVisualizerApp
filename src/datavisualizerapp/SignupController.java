/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datavisualizerapp;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author leo
 */
public class SignupController implements Initializable {

    @FXML
    private JFXTextField usrname;
    @FXML
    private JFXPasswordField pswd;
    @FXML
    private JFXButton createacct;
    @FXML
    private JFXPasswordField cpswd;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXTextField name;
    @FXML
    private Label status;
    @FXML
    private ImageView img;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void createAccntButton(ActionEvent event) {
        
        if (!pswd.getText().equals(cpswd.getText())){
            status.setText("Passwords dont Match");
        }
        else if ((pswd.getText() == null || cpswd.getText() == null)){
            status.setText("Password Field cant be empty");
        }
        else {
            status.setText("Account Creation Succesfull");
            System.out.println("Account Creation Succesfull");
        }
    }
}
