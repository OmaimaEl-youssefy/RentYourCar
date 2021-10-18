package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDAO {

    public static void ajouter(int CodeClient,String nomClient, String adresse) throws SQLException,ClassNotFoundException{
        String sql="INSERT into client (CodeClient,nomClient,adresse) values ('"+CodeClient+"','"+nomClient+"','"+adresse+"');";
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

    public static void  modifier(int IdClient ,int CodeClient ,String nomClient,String adresse) throws SQLException,ClassNotFoundException {
        String sql ="update client set nomClient = '"+nomClient+"', adresse='"+adresse+"',CodeClient='"+CodeClient+"'  where IdClient= '"+IdClient+"' ";

        try{
            DBUtil.dbExcecuteQuery(sql);
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }

    public static void supprimer(int IdClient) throws SQLException,ClassNotFoundException{
        String sql="delete from client where IdClient= '"+IdClient+"'";
        try{
            DBUtil.dbExcecuteQuery(sql);
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }

    public static ObservableList<Client> chercher(int IdClient) throws SQLException,ClassNotFoundException{
        String sql="SELECT * FROM client where IdClient='"+IdClient+"' ";
        try{
            ResultSet result=DBUtil.dbExecute(sql);
            ObservableList<Client>  list=getClientObjects(result);
            return list;
        }
        catch(SQLException e){
            System.out.println("Error ocured while searching the record "+ e);
            e.printStackTrace();
            throw e;
        }
    }
    public static ObservableList<Client> getClient() throws ClassNotFoundException,SQLException{
        String sql="SELECT * FROM client";
        try{
            ResultSet  resultClient =DBUtil.dbExecute(sql);
            ObservableList<Client> listClient= getClientObjects(resultClient);
            return listClient;
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }

    private static ObservableList<Client> getClientObjects(ResultSet result) throws ClassNotFoundException,SQLException{
        try{
            ObservableList<Client> listClient= FXCollections.observableArrayList();
            while(result.next()){
                Client client=new Client();
                client.setIdClient(result.getInt("IdClient"));
                client.setCodeClient(result.getInt("CodeClient"));
                client.setNomClient(result.getString("nomClient"));
                client.setAdresse(result.getString("adresse"));
                listClient.add(client);
            }
            return listClient;
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }

    }
}