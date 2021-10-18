package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class ReservationDAO {

    public static void ajouter(int codeReservation, LocalDate dateReservation, LocalDate dateDepart, LocalDate dateRetour, String reservationStatus) throws SQLException,ClassNotFoundException{
        String sql="INSERT into reservation (codeReservation,dateReservation,dateDepart,dateRetour,reservationStatus) values ('"+codeReservation+"','"+dateReservation+"','"+dateDepart+"','"+dateRetour+"','"+reservationStatus+"');";
        try{
            DBUtil.dbExcecuteQuery(sql);

        }
        catch(SQLException  e){
            System.out.println("Exception insert while inserting the data"+e);
            e.printStackTrace();
            throw e;
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
            throw e;
        }
    }


    public static void  modifier(int codeReservation , LocalDate dateReservation,LocalDate dateDepart,LocalDate dateRetour,String reservationStatus) throws SQLException,ClassNotFoundException {
        String sql ="update reservation set dateReservation = '"+dateReservation+"',dateDepart='"+dateDepart+"',dateRetour='"+dateRetour+"',reservationStatus='"+reservationStatus+"'  where codeReservation= '"+codeReservation+"' ";

        try{
            DBUtil.dbExcecuteQuery(sql);
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }

    public static void supprimer(int codeReservation) throws SQLException,ClassNotFoundException{
        String sql="delete from reservation where codeReservation= '"+codeReservation+"'";
        try{
            DBUtil.dbExcecuteQuery(sql);
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }

    public static ObservableList<Reservation> chercher(int codeReservation) throws SQLException,ClassNotFoundException{
        String sql="SELECT * FROM reservation where codeReservation='"+codeReservation+"' ";
        try{
            ResultSet result=DBUtil.dbExecute(sql);
            ObservableList<Reservation>  list=getReservationObjects(result);
            return list;
        }
        catch(SQLException e){
            System.out.println("Error ocured while searching the record "+ e);
            e.printStackTrace();
            throw e;
        }
    }

    public static ObservableList<Reservation> getReservation() throws ClassNotFoundException,SQLException{
        String sql="SELECT * FROM reservation";
        try{
            ResultSet  resultReservation =DBUtil.dbExecute(sql);
            ObservableList<Reservation> listReservation= getReservationObjects(resultReservation);
            return listReservation;
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }

    private static ObservableList<Reservation> getReservationObjects(ResultSet result) throws ClassNotFoundException,SQLException{
        try{
            ObservableList<Reservation> listReservation= FXCollections.observableArrayList();
            while(result.next()){
                Reservation reservation = new Reservation();
                reservation.setCodeReservation(result.getInt("codeReservation"));
                reservation.setDateReservation(result.getString("dateReservation"));
                reservation.setDateDepart(result.getString("dateDepart"));
                reservation.setDateRetour(result.getString("dateRetour"));
                reservation.setReservationStatus(result.getString("reservationStatus"));

                listReservation.add(reservation);
            }
            return listReservation;
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }

    }

    public static ObservableList<Reservation> chercherReservation(String reservationStatus) throws SQLException,ClassNotFoundException{
        String sql="SELECT * FROM reservation where reservationStatus='"+reservationStatus+"' ";
        try{
            ResultSet result=DBUtil.dbExecute(sql);
            ObservableList<Reservation>  list=getReservationObjects(result);
            return list;
        }
        catch(SQLException e){
            System.out.println("Error ocured while searching the record "+ e);
            e.printStackTrace();
            throw e;
        }
    }


}
