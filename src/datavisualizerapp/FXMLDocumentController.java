package datavisualizerapp;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSlider;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Pair;
import javax.swing.JOptionPane;

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
    @FXML
    private JFXButton open;
    @FXML
    private JFXButton close;
    @FXML
    private JFXButton edit;
    @FXML
    private JFXButton undo;
    @FXML
    private JFXButton redo;
    @FXML
    private JFXButton max;
    @FXML
    private JFXButton min;
    @FXML
    private JFXSlider slider;
    @FXML
    private JFXButton hand;
    @FXML
    private JFXButton select;
    @FXML
    private JFXButton expand;
    @FXML
    private JFXButton snapshot;
    @FXML
    private JFXButton screencap;
    @FXML
    private JFXButton picture;
    @FXML
    private ColorPicker color;

    @FXML
    private JFXButton refresh;

    // Charts .................................//
    private BarChart<String, Double> barChart;

    @FXML
    private TitledPane lineChart;

    //.........................................//
    @FXML
    private Label namefield;
    @FXML
    private JFXButton login;
    @FXML
    private JFXButton save;
    @FXML
    private JFXButton fill;
    @FXML
    private JFXButton copy;
    @FXML
    private Pane pane;
    @FXML
    private Label llabel;
    @FXML
    private Label rlabel;
    @FXML
    private AnchorPane barChartpane;
    @FXML
    private JFXButton loadall;
    @FXML
    private AnchorPane pieChartpane;
    @FXML
    private AnchorPane scatterChartpane;
    @FXML
    private AnchorPane lineChartpane;

    public Connection connection;

    //Method to load login Interface
    @FXML
    public void loginButtonAction() throws IOException {

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

    /**
     * Method to refresh all loaded Charts
     */
    @FXML
    public void refreshchartButton() {
    }

    /**
     * ********************************** Method to Load all Charts   *********************************
     */
    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void loadchartsButton(ActionEvent event) throws IOException {

        AnchorPane pane1 = FXMLLoader.load(getClass().getResource("barchart.fxml"));
        barChartpane.getChildren().setAll(pane1);
        AnchorPane pane2 = FXMLLoader.load(getClass().getResource("piechart.fxml"));
        pieChartpane.getChildren().setAll(pane2);
        AnchorPane pane3 = FXMLLoader.load(getClass().getResource("scatterchart.fxml"));
        scatterChartpane.getChildren().setAll(pane3);
        AnchorPane pane4 = FXMLLoader.load(getClass().getResource("linechart.fxml"));
        lineChartpane.getChildren().setAll(pane4);

    }

    /**
     * ************************************ Method to Load Database **************************************
     * @return 
     */
    //Method to connect to our Database
    public Connection connectDB() {
        // Create the custom dialog.
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Login Dialog");
        dialog.setHeaderText("Enter Username and password");

     // Set the icon
        dialog.setGraphic(new ImageView(this.getClass().getResource("login-filled.png").toString()));

     // Set the button types.
        ButtonType loginButtonType = new ButtonType("Login", ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

     // Create the username and password labels and fields.
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        

        TextField username = new TextField();
        username.setPromptText("Username");
        PasswordField password = new PasswordField();
        password.setPromptText("Password");

        grid.add(new Label("Username:"), 0, 0);
        grid.add(username, 1, 0);
        grid.add(new Label("Password:"), 0, 1);
        grid.add(password, 1, 1);

     // Enable/Disable login button depending on whether a username was entered.
        Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
        loginButton.setDisable(true);

      // Do some validation (using the Java 8 lambda syntax).
        username.textProperty().addListener((observable, oldValue, newValue) -> {
            loginButton.setDisable(newValue.trim().isEmpty());
        });

        dialog.getDialogPane().setContent(grid);

     // Request focus on the username field by default.
        Platform.runLater(() -> username.requestFocus());

     // Convert the result to a username-password-pair when the login button is clicked.
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == loginButtonType) {
                return new Pair<>(username.getText(), password.getText());
            }
            return null;
        });

        Optional<Pair<String, String>> result = dialog.showAndWait();

        result.ifPresent(usernamePassword -> {
            System.out.println("Username=" + usernamePassword.getKey() + ", Password=" + usernamePassword.getValue());
        });
        
        try {
            String dbString ;
            dbString = "jdbc:mysql://localhost:3306/student_record?zeroDateTimeBehavior=convertToNull";
            String user = username.getText();
            String pswd= password.getText();

            Connection connect;
            connect = DriverManager.getConnection(dbString, user, pswd);
            JOptionPane.showMessageDialog(null,"Connected");
            System.out.println("Connection Succesfull");
            return connect;

        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Connection Failed");
        }
        return null;
    }

}
