import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Database.DataBase;

public class App {
    public static void main(String[] args) throws Exception {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try{
            conn = DataBase.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select * from department");

            while(rs.next()){
                System.out.println(rs.getInt("ID") + ", " + rs.getString("Name"));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            conn.close();
            DataBase.closeStatement(st);
            rs.close();
        }
    }
}
