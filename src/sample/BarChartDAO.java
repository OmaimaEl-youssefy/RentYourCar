package sample;

import javafx.scene.chart.XYChart;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class BarChartDAO {

    public static ResultSet load(LocalDate start, LocalDate end) throws ClassNotFoundException, SQLException
    {
            String  sql="SELECT MONTHNAME(dateReservation),COUNT(dateReservation) from reservation where DATE(dateReservation) between '"+start+"' and '"+end+"' group by MONTH(dateReservation) order by MONTH(dateReservation)";
        try {

           ResultSet res= DBUtil.dbExecute(sql);
           return res;

        }catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }

}
