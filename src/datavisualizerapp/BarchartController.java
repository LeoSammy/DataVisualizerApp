/*
 * Implementation of BarChart Controller for BarChart 
 */
package datavisualizerapp;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author leo
 */
public class BarchartController extends FXMLDocumentController implements Initializable {

   
    @FXML
    private JFXButton load;
    @FXML
    private CategoryAxis xAxis;
    @FXML
    private NumberAxis yAxis;
    
    @FXML
    private BarChart<String, Double> barChart;
 
    
    /**
     * Initializes the controller class.
     * @param event
     */
   
    @FXML
    private void loadBarChart() {
        String query;
        query = "select S_Lname, S_Gpa FROM students ORDER BY S_Gpa asc";
        XYChart.Series<String, Double> series;
        series = new XYChart.Series<>();

        try {
            //Connect to database   
            connection = connectDB();
            //Execute query and Store

            ResultSet rs = connection.createStatement().executeQuery(query);
            while (rs.next()) {
               series.getData().add(new XYChart.Data<>(rs.getString(1), rs.getDouble(2)));
               
            }

           barChart.getData().add(series);
        } catch (SQLException e) {
        }

    }

  //Initializer 
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

}
