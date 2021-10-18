package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.DatePicker;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BarChartController {

    @FXML BarChart<String,Integer> barChart;
    @FXML DatePicker start;
    @FXML DatePicker end;


    @FXML public void load(ActionEvent event) throws ClassNotFoundException, SQLException
    {
        try {
            XYChart.Series<String, Integer> series = new XYChart.Series<>();
            ResultSet res = BarChartDAO.load(start.getValue(),end.getValue());
            while (res.next())
            {
                series.getData().addAll(new XYChart.Data<>(res.getString(1),res.getInt(2)));

            }
            barChart.getData().add(series);
            } catch(SQLException e){
        e.printStackTrace();
        throw e; }
    }



}
