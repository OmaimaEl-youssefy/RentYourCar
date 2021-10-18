package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ParkingDAO {

    public static void ajouter(int numParking,String capacite, String rue,String arrondissement) throws SQLException,ClassNotFoundException{
        String sql="INSERT into parking (numParking,capacite,rue,arrondissement) values ('"+numParking+"','"+capacite+"','"+rue+"','"+arrondissement+"');";
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

    public static void  modifier(int numParking ,String capacite,String rue,String arrondissement) throws SQLException,ClassNotFoundException {
        String sql ="update parking set  capacite='"+capacite+"',rue='"+rue+"',arrondissement='"+arrondissement+"'  where numParking= '"+numParking+"' ";

        try{
            DBUtil.dbExcecuteQuery(sql);
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }

    public static void supprimer(int numParking) throws SQLException,ClassNotFoundException{
        String sql="delete from parking where numParking= '"+numParking+"'";
        try{
            DBUtil.dbExcecuteQuery(sql);
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }

    public static ObservableList<Parking> chercher(int numParking) throws SQLException,ClassNotFoundException{
        String sql="SELECT * FROM parking where numParking='"+numParking+"' ";
        try{
            ResultSet result=DBUtil.dbExecute(sql);
            ObservableList<Parking>  list=getParkingObjects(result);
            return list;
        }
        catch(SQLException e){
            System.out.println("Error ocured while searching the record "+ e);
            e.printStackTrace();
            throw e;
        }
    }
    public static ObservableList<Parking> getParking() throws ClassNotFoundException,SQLException{
        String sql="SELECT * FROM parking";
        try{
            ResultSet  resultParking =DBUtil.dbExecute(sql);
            ObservableList<Parking> listParking= getParkingObjects(resultParking);
            return listParking;
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }

    private static ObservableList<Parking> getParkingObjects(ResultSet result) throws ClassNotFoundException,SQLException{
        try{
            ObservableList<Parking> listParking= FXCollections.observableArrayList();
            while(result.next()){
                Parking parking=new Parking();
                parking.setParkingId(result.getInt("parkingId"));
                parking.setNumParking(result.getInt("numParking"));
                parking.setCapacite(result.getString("capacite"));
                parking.setRue(result.getString("rue"));
                parking.setArrondissement(result.getString("arrondissement"));
                listParking.add(parking);
            }
            return listParking;
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }

    }

    public static void sortirVehicule(String numVehicule) throws SQLException,ClassNotFoundException{
          String sql=" UPDATE vehicule SET numParking = NULL WHERE numImmatriculation='"+numVehicule+"' ";
        try{
           DBUtil.dbExcecuteQuery(sql);
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }


    public static void deposerVehicule(int Park,String numVehicule) throws SQLException,ClassNotFoundException{
        String sql=" UPDATE vehicule SET numParking ='"+Park+"' WHERE numImmatriculation='"+numVehicule+"' ";
        try{
                DBUtil.dbExcecuteQuery(sql);
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }

    public static void restituerVehicule(int Park,String numVehicule) throws SQLException,ClassNotFoundException{
        String sql=" UPDATE vehicule SET numParking ='"+Park+"' WHERE numImmatriculation='"+numVehicule+"' ";

        try{
            DBUtil.dbExcecuteQuery(sql);
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }

   public static int nombreDePlaceVide(int Park) throws SQLException,ClassNotFoundException {
        String sql = "SELECT COUNT(*) FROM vehicule where numParking='"+Park+"'";
        try {
            ResultSet res = DBUtil.dbExecute(sql);
            while (res.next()) {

                int val = res.getInt(1);
                int var=capacite(Park)-val;
                return var;
            }return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

    }

    public static int capacite(int Park) throws SQLException,ClassNotFoundException {
        String sql = "SELECT capacite FROM parking where numParking='"+Park+"'";
        try {
            ResultSet res = DBUtil.dbExecute(sql);
            while (res.next()) {
                int val = (res.getInt(1));
                return val;
            }return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

    }



}