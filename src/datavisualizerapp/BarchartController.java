/*
 * Implementation of BarChart Controller for BarChart 
 */
package datavisualizerapp;

import com.jfoenix.controls.JFXButton;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author leo
 */
public class BarchartController extends FXMLDocumentController {

    @FXML
    private BarChart<String, Double> barChart;
    @FXML
    private JFXButton load;

    /**
     * Initializes the controller class.
     * @param event
     */
   
    @FXML
    private void loadBarChart(ActionEvent event) {
        String query;
        query = "select S_Lname, S_Fname from students order by S_Gpa asc";
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

  

}
