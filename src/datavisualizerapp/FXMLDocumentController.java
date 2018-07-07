package datavisualizerapp;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSlider;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
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
    @FXML
    private ImageView open;
    @FXML
    private ImageView saveas;
    @FXML
    private ImageView close;
    @FXML
    private ImageView edit;
    @FXML
    private ImageView paste;
    @FXML
    private JFXButton undo;
    @FXML
    private ImageView redo;
    @FXML
    private ImageView max;
    @FXML
    private ImageView min;
    @FXML
    private JFXSlider slider;
    @FXML
    private ImageView hand;
    @FXML
    private ImageView select;
    @FXML
    private ImageView expand;
    @FXML
    private ImageView snapshot;
    @FXML
    private ImageView screencap;
    @FXML
    private ImageView picture;
    @FXML
    private ColorPicker color;
    @FXML
    private JFXButton load;
    @FXML
    private JFXButton refresh;
    @FXML
    private BarChart<String, Double> barChart;
    
    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;

    @FXML
    private ScatterChart<?, ?> scatterChart;

    @FXML
    private PieChart pieChart;
    
    @FXML
    private TitledPane lineChart;

    @FXML
    private Label namefield;
    @FXML
    private JFXButton login;

    private Connection connection;

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

    @FXML
    private void loadchartButton(ActionEvent event) {
        String query = "SELECT S_Fname,S_Address FROM students ORDER BY S_id asc";
        XYChart.Series<String, Double> series = new XYChart.Series<>();
        
        try {
            //Connect to database

            connection = connectDB();
            //Execute query and Store

            ResultSet rs = connection.createStatement().executeQuery(query);
            while (rs.next()) {
                series.getData().add(new XYChart.Data<>(rs.getString(1), rs.getDouble(2)));
            }

            barChart.getData().add(series);

        } catch (Exception e) {
        }

    }

    @FXML
    private void refreshChart(ActionEvent event) {
    }

    //Method to connect to our Database
    private Connection connectDB() {
        try {
            String dbString = "jdbc:mysql://localhost:3306/mysql";
            String user = "root";
            String password = "Firecell1234";

            Connection connect = DriverManager.getConnection(dbString, user, password);
            System.out.println("Connection Succesfull");

            return connect;

        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
