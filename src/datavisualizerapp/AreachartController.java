package datavisualizerapp;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author leo
 */
public class AreachartController extends FXMLDocumentController implements Initializable {

    @FXML
    private NumberAxis yAxis;
    @FXML
    private JFXButton load;
    @FXML
    private AreaChart<String, Double> areaChart;

   

    @FXML
    private void loadAreaChart() {
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

           areaChart.getData().add(series);
        } catch (SQLException e) {
        }
        
    }
     /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
