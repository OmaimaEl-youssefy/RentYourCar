package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;


public class FactureDAO {



    public static void ajouter(LocalDate dateFacture, double montant) throws SQLException,ClassNotFoundException{
        String sql="INSERT into facture (dateFacture,montant) values ('"+dateFacture+"','"+montant+"');";
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


    public static void  modifier(int numFacture , LocalDate dateFacture,double montant) throws SQLException,ClassNotFoundException {
        String sql ="update facture set dateFacture = '"+dateFacture+"', montant='"+montant+"'  where numFacture= '"+numFacture+"' ";

        try{
            DBUtil.dbExcecuteQuery(sql);
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }

    public static void supprimer(int numFacture) throws SQLException,ClassNotFoundException{
        String sql="delete from facture where numFacture= '"+numFacture+"'";
        try{
            DBUtil.dbExcecuteQuery(sql);
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }

    public static ObservableList<Facture> chercher(int numFacture) throws SQLException,ClassNotFoundException{
        String sql="SELECT * FROM facture where numFacture='"+numFacture+"' ";
        try{
            ResultSet  result=DBUtil.dbExecute(sql);
            ObservableList<Facture>  list=getFactureObjects(result);
            return list;
        }
        catch(SQLException e){
            System.out.println("Error ocured while searching the record "+ e);
            e.printStackTrace();
            throw e;
        }
    }

    public static ObservableList<Facture> getFacture() throws ClassNotFoundException,SQLException{
        String sql="SELECT * FROM facture";
        try{
            ResultSet  resultFacture =DBUtil.dbExecute(sql);
            ObservableList<Facture> listFacture= getFactureObjects(resultFacture);
            return listFacture;
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }

    private static ObservableList<Facture> getFactureObjects(ResultSet result) throws ClassNotFoundException,SQLException{
        try{
            ObservableList<Facture> listFacture= FXCollections.observableArrayList();
            while(result.next()){
                Facture facture=new Facture();
                facture.setNumFacture(result.getInt("numFacture"));
                facture.setDateFacture(result.getString("dateFacture"));
                facture.setMontant(result.getDouble("montant"));
                listFacture.add(facture);
            }
            return listFacture;
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }

    }

}