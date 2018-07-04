
package datavisualizerapp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.stage.Stage;

/**
 *
 * @author leo
 */
public class FXMLDocumentController implements Initializable {
   
    @FXML
    private Menu Load;
    @FXML
    private Menu Edit;
    @FXML
    private Menu View;
    @FXML
    private Menu Help;
    @FXML
    private Menu File;
   
    //Function to load login Screen
    @FXML
    private void loginButtonAction(ActionEvent event) throws IOException {
        
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("Login window");
        stage.show();
        
        
        System.out.println("logging in...");
       
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
