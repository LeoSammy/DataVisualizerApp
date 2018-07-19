package datavisualizerapp;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author leo
 * 
 */
public class ScatterchartController extends FXMLDocumentController implements Initializable {

    @FXML
    private JFXButton load;
    @FXML
    private ScatterChart<String, Double> scatterChart;

    

    @FXML
    private void loadScatterChart() {
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

           scatterChart.getData().add(series);
        } catch (SQLException e) {
        }

    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
