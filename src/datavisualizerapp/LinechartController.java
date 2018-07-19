package datavisualizerapp;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author leo
 */
public class LinechartController extends FXMLDocumentController implements Initializable {
    
    
    @FXML
    private JFXButton load;
    @FXML
    private LineChart<String,Double> lineChart;
    @FXML
    private NumberAxis yAxis;
    @FXML
    private CategoryAxis xAxis;

    @FXML
    private void loadLineChart() {
      String query1;
        query1 = "select S_Fname, S_Gpa FROM students";
        XYChart.Series<String, Double> series;
        series = new XYChart.Series<>();

        try {
            //Connect to database   
            connection = connectDB();
            //Execute query and Store

            ResultSet rs = connection.createStatement().executeQuery(query1);
            while (rs.next()) {
               series.getData().add(new XYChart.Data<>(rs.getString(1), rs.getDouble(2)));
               
            }

           lineChart.getData().add(series);
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
