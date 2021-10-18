package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilisateurDAO {
    public static void ajouter(String name, String password, String conge, String genre) throws SQLException,ClassNotFoundException{
        String sql="INSERT into utilisateur (name,password,conge,genre) values ('"+name+"','"+password+"','"+conge+"','"+genre+"');";
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

    public static void  modifier(String name, String password, String conge,String genre) throws SQLException,ClassNotFoundException {
        String sql ="update utilisateur set password = '"+password+"',conge = '"+conge+"',genre = '"+genre+"'  where name= '"+name+"' ";

        try{
            DBUtil.dbExcecuteQuery(sql);
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }

    public static void supprimer(String name) throws SQLException,ClassNotFoundException{
        String sql="delete from utilisateur where name= '"+name+"'";
        try{
            DBUtil.dbExcecuteQuery(sql);
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }

    public static ObservableList<Utilisateur> chercher(String name) throws SQLException,ClassNotFoundException{
        String sql="SELECT * FROM utilisateur where name='"+name+"' ";
        try{
            ResultSet result=DBUtil.dbExecute(sql);
            ObservableList<Utilisateur>  list=getUtilisateurObjects(result);
            return list;
        }
        catch(SQLException e){
            System.out.println("Error ocured while searching the record "+ e);
            e.printStackTrace();
            throw e;
        }
    }

    public static ObservableList<Utilisateur> getUtilisateur() throws ClassNotFoundException,SQLException{
        String sql="SELECT * FROM utilisateur";
        try{
            ResultSet  resultUtilisateur =DBUtil.dbExecute(sql);
            ObservableList<Utilisateur> listUtilisateur= getUtilisateurObjects(resultUtilisateur);
            return listUtilisateur;
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }

    private static ObservableList<Utilisateur> getUtilisateurObjects(ResultSet result) throws ClassNotFoundException,SQLException{
        try{
            ObservableList<Utilisateur> listUtilisateur= FXCollections.observableArrayList();
            while(result.next()){
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setName(result.getString("name"));
                utilisateur.setPassword(result.getString("password"));
                utilisateur.setConge(result.getString("conge"));
                utilisateur.setGenre(result.getString("genre"));

                listUtilisateur.add(utilisateur);
            }
            return listUtilisateur;
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }

    }
}
