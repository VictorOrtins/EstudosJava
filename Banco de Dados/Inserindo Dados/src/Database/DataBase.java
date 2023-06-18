package Database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import Database.exceptions.DbException;

public class DataBase {

    private static Connection conn = null;

    public static Connection getConnection(){
        if(conn == null){
            try{
                Properties props = loadProperties();
                String url = props.getProperty("dburl");
                conn = DriverManager.getConnection(url, props);
            }
            catch(Exception e){
                throw new DbException(e.getMessage());
            }
        }
        return conn;
    }

    public static void closeConnection(){
        if(conn != null){
            try{
                conn.close();
            }
            catch(SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }
    
    private static Properties loadProperties(){
        try(BufferedReader br = new BufferedReader(new FileReader("db.properties"))){
            Properties props = new Properties();
            props.load(br);
            return props;
        }
        catch(IOException e){
            throw new DbException(e.getMessage());
        }
    }

    public static void closeStatement(Statement st){
        if(st != null){
            try {
                st.close();
            } catch (SQLException e) {
               throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet st){
        if(st != null){
            try {
                st.close();
            } catch (SQLException e) {
               throw new DbException(e.getMessage());
            }
        }
    }
}
