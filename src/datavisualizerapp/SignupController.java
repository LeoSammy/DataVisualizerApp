package datavisualizerapp;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author leo
 */
public class  SignupController  extends FXMLDocumentController {

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
    
    PreparedStatement pst;
   
   
    @FXML
    private void createAccntButton(ActionEvent event) {
        
        if (!pswd.getText().equals(cpswd.getText())){
            status.setText("Passwords dont Match");
        }
        else if ((pswd.getText() == null || cpswd.getText().isEmpty())){
                 status.setText("Password Required");
        }
        
        else {
            status.setText("Account Creation Succesful");
              
        /******************************** Method to Inject Data into Database Server   *********************/
         dconnection = usersDB();
         try {
            String sql;
            sql = "insert into users (user_id, user_name, user_email, user_usrname,user_pswd) values (?,?,?,?,?)";
             
            pst = dconnection.prepareStatement(sql);
            
            pst.setString(1, null);
            pst.setString(2, name.getText());
            pst.setString(3, email.getText());
            pst.setString(4, usrname.getText()); 
            pst.setString(5, pswd.getText()); 
            
            pst.execute();
            System.out.println("save succesfull");
        } catch (SQLException e) {
             System.out.println(e);
             
        }
             
        }
        
      
        

    }
   
    
        
}
