package datavisualizerapp;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author leo
 */
public class LoginController extends FXMLDocumentController {

    @FXML
    private JFXTextField usrname;
    @FXML
    private JFXPasswordField pswd;
    @FXML
    private Label stats;

    

    @FXML
    public void lgnButtonAction(ActionEvent event) throws IOException {
        //Verification if user is Authenticated rightly
        //Connection to users database
        String query;
        query = "SELECT user_usrname, user_pswd from users";

        try {

            dconnection = usersDB();

            ResultSet rs = dconnection.createStatement().executeQuery(query);
            while (rs.next()) {
                //Retrieve by column name
                String dbValue1 = rs.getString("user_usrname");
                String dbvalue2 = rs.getString("user_pswd");

                if ((usrname.getText() == null ? dbValue1 == null : usrname.getText().equals(dbValue1)) && (pswd.getText() == null ? dbvalue2 == null : pswd.getText().equals(dbvalue2))) {
                    stats.setText("Login Succesfull");
                    System.out.println("login confirmed");
                 
                } else {
                    stats.setText("Login Failed");
                }
            }
        } catch (SQLException e) {
            System.out.println("failed to login");
        }

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
