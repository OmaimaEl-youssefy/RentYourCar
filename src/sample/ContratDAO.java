package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class ContratDAO {
    public static void ajouter(LocalDate dateContrat,LocalDate dateEcheance) throws SQLException,ClassNotFoundException{
        String sql="INSERT into contrat (dateContrat,dateEcheance) values ('"+dateContrat+"','"+dateEcheance+"') ";
        try{
            DBUtil.dbExcecuteQuery(sql);
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
            throw e;
        }
    }

    public static void modifier(int numContrat ,LocalDate dateContrat,LocalDate dateEcheance)  throws SQLException,ClassNotFoundException{
        String sql="UPDATE contrat set dateContrat='"+dateContrat+"' ,dateEcheance='"+dateEcheance+"' where NumContrat='"+numContrat+"' ";
        try{
            DBUtil.dbExcecuteQuery(sql);
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }


    }

    public static void supprimer(int numContrat)throws SQLException,ClassNotFoundException{
        String sql="delete from contrat where NumContrat='"+numContrat+"'";
        try{
            DBUtil.dbExcecuteQuery(sql);
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }

    public static ObservableList<Contrat> chercher(int numContrat) throws SQLException,ClassNotFoundException {
        String sql="SELECT * from contrat where  NumContrat='"+numContrat+"'";

        try{
            ResultSet resultContrat=DBUtil.dbExecute(sql);
            ObservableList<Contrat> listContrat=getContartObjects(resultContrat);
            return listContrat;
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }

    public static ObservableList<Contrat> getContrat() throws SQLException,ClassNotFoundException{
        String sql="SELECT * FROM contrat";
        try{
            ResultSet resultContrat=DBUtil.dbExecute(sql);
            ObservableList<Contrat> listContrat=  getContartObjects(resultContrat);
            return listContrat;
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }

    private static ObservableList<Contrat> getContartObjects(ResultSet result)throws SQLException,ClassNotFoundException {
        try{
            ObservableList<Contrat> listeContrat= FXCollections.observableArrayList();
            while(result.next()){
                Contrat contrat=new Contrat();
                contrat.setNumContrat(result.getInt("NumContrat"));
                contrat.setDateContrat(result.getString("dateContrat"));
                contrat.setDateEcheance(result.getString("dateEcheance"));
                listeContrat.add(contrat);
            }
            return listeContrat;
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }


}