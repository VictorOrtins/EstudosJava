import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import Database.DataBase;
import Database.exceptions.DbException;

/*
 * Tá sempre dando erro de rollback
 */

public class App {
    public static void main(String[] args) throws Exception {
        Connection conn = null;
        Statement st = null;


        try{
            conn = DataBase.getConnection();

            st = conn.createStatement();
            conn.setAutoCommit(true);

            int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 Where DepartmentId = 1");

            int x = 1;
            
            conn.commit();

            if(x < 2){
                throw new SQLException("Fake Error");
            }

            int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 Where DepartmentId = 2");
            System.out.println("Done! rowsAffected = " + rows1 + rows2);
                
        }
        catch(Exception e){
            try{
                conn.rollback();
                throw new DbException("Transaction rolled back");
            }
            catch(SQLException f){
                throw new DbException("Error trying to rollback");
            }
        }
        finally{
            DataBase.closeStatement(st);
            DataBase.closeConnection();
        }
    }
}
