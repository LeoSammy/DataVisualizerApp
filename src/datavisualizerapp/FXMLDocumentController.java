
package datavisualizerapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;

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
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
