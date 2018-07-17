/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datavisualizerapp;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;

/**
 * FXML Controller class
 *
 * @author leo
 */
public class PiechartController extends FXMLDocumentController implements Initializable {

    @FXML
    private JFXButton load;
    @FXML
    private PieChart Piechart;

    PreparedStatement ps;
    ResultSet rs;

    ObservableList<PieChart.Data> piechartdata;

    ArrayList<Float> gpa = new ArrayList<Float>();
    ArrayList<String> name = new ArrayList<String>();
  
    @FXML
    private void loadPieChart() {
        piechartdata = FXCollections.observableArrayList();
        try {
            //Connect to Database 
            connection = connectDB();
            //Query  
            ps = connection.prepareStatement("select *from students where S_Gpa > 3.0");
            rs = ps.executeQuery();
            while (rs.next()) {

                piechartdata.add(new PieChart.Data(rs.getString("S_Fname"), rs.getFloat("S_Gpa")));
                name.add(rs.getString("S_Fname"));
                gpa.add(rs.getFloat("S_Gpa"));
            }
        } catch (SQLException e) {
        }
    }

    //Initailizable
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadPieChart();
        Piechart.setData(piechartdata);

    }
}
