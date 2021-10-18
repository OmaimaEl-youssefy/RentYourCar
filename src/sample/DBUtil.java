package sample;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.*;

public class DBUtil {
    private static final String DRIVER="com.mysql.cj.jdbc.Driver";
    private static Connection connection=null;
    private static final String connStr="jdbc:mysql://localhost:3306/projetJava?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static void dbConnect() throws SQLException,ClassNotFoundException{
        try{
            Class.forName(DRIVER);
        }
        catch (ClassNotFoundException e){
            System.out.println("MySql JDBC not found");
            e.printStackTrace();
            throw e;
        }

        System.out.println("JDBC Driver has been registred!");

        try{
            connection=DriverManager.getConnection(connStr,"root","greatlive1998");
        }
        catch(SQLException e){
            System.out.println("Connection failed!");
            throw e;
        }

    }

    public static void dbDisconnect() throws SQLException{
        try{
            if(connection != null && !connection.isClosed())
                connection.close();
        }
        catch(SQLException e){
            throw e;
        }

    }

    public static void dbExcecuteQuery(String sqlStmt) throws SQLException,ClassNotFoundException{
        Statement stmt=null;
        try{
            dbConnect();
            stmt=connection.createStatement();
            stmt.executeUpdate(sqlStmt);
        }
        catch(SQLException e){
            System.out.println("dbExecutionQuery ERROR"+e);
            throw e;
        }
        finally {
            if(stmt!=null){
                stmt.close();
            }
            dbDisconnect();
        }
    }

    public static ResultSet dbExecute(String sqlQuery) throws ClassNotFoundException,SQLException{
        Statement stmt=null;
        ResultSet rs=null;
        CachedRowSetImpl crs=null;
        try{
            dbConnect();
            stmt=connection.createStatement();
            rs=stmt.executeQuery(sqlQuery);
            crs=new CachedRowSetImpl();
            crs.populate(rs);
        }
        catch(SQLException e){
            System.out.println("dbExecute ERROER "+e);
            throw e;
        }
        finally {
            if(rs != null){
                rs.close();
            }
            if(stmt!=null){
                stmt.close();
            }
            dbDisconnect();
        }
        return crs;
    }
}