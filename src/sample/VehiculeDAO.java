package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class VehiculeDAO {

    public static void ajouter(LocalDate dateCirculation, String numImmatriculation,String marque,String type,int parking,float compteurKm,String carburant) throws SQLException,ClassNotFoundException{
        String sql="INSERT into vehicule (dateCirculation,numImmatriculation,marque,type,numParking,compteurKm,carburant) values ('"+dateCirculation+"','"+numImmatriculation+"','"+marque+"','"+type+"','"+parking+"','"+compteurKm+"','"+carburant+"');";
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

    public static void  modifier(String numImmatriculation, String marque, String type, int parking, float compteurKm, LocalDate dateCirculation,String carburant) throws SQLException,ClassNotFoundException {
        String sql ="update vehicule set dateCirculation = '"+dateCirculation+"',marque='"+marque+"',type='"+type+"',numParking='"+parking+"',compteurKm='"+compteurKm+"',carburant='"+carburant+"'  where numImmatriculation= '"+numImmatriculation+"' ";

        try{
            DBUtil.dbExcecuteQuery(sql);
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }

    public static void supprimer(String numImmatriculation) throws SQLException,ClassNotFoundException{
        String sql="delete from vehicule where numImmatriculation= '"+numImmatriculation+"'";
        try{
            DBUtil.dbExcecuteQuery(sql);
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }

    public static ObservableList<Vehicule> chercher(String numImmatriculation) throws SQLException,ClassNotFoundException{
        String sql="SELECT * FROM vehicule where numImmatriculation='"+numImmatriculation+"' ";
        try{
            ResultSet result=DBUtil.dbExecute(sql);
            ObservableList<Vehicule>  list=getVehiculeObjects(result);
            return list;
        }
        catch(SQLException e){
            System.out.println("Error ocured while searching the record "+ e);
            e.printStackTrace();
            throw e;
        }
    }

    public static ObservableList<Vehicule> getVehicule() throws ClassNotFoundException,SQLException{
        String sql="SELECT * FROM vehicule";
        try{
            ResultSet  resultVehicule =DBUtil.dbExecute(sql);
            ObservableList<Vehicule> listVehicule= getVehiculeObjects(resultVehicule);
            return listVehicule;
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }

    private static ObservableList<Vehicule> getVehiculeObjects(ResultSet result) throws ClassNotFoundException,SQLException{
        try{
            ObservableList<Vehicule> listVehicule= FXCollections.observableArrayList();
            while(result.next()){
                Vehicule vehicule = new Vehicule();
                vehicule.setNumImmatriculation(result.getString("numImmatriculation"));
                vehicule.setDateCirculation(result.getString("dateCirculation"));
                vehicule.setType(result.getString("type"));
                vehicule.setParking(result.getInt("numParking"));
                vehicule.setMarque(result.getString("marque"));
                vehicule.setCompteurKm(result.getFloat("compteurKm"));
                vehicule.setCarburant(result.getString("carburant"));
                listVehicule.add(vehicule);
            }
            return listVehicule;
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }

    }

    public static ObservableList<Vehicule> chercherVehiculeSelonParking(Integer park) throws SQLException,ClassNotFoundException{
        String sql="SELECT * FROM vehicule where numParking='"+park+"' ";
        try{
            ResultSet result=DBUtil.dbExecute(sql);
            ObservableList<Vehicule>  list=getVehiculeObjects(result);
            return list;
        }
        catch(SQLException e){
            System.out.println("Error ocured while searching the record "+ e);
            e.printStackTrace();
            throw e;
        }
    }

}
