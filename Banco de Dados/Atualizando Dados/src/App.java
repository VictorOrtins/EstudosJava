import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import Database.DataBase;

public class App {
    public static void main(String[] args) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;

        try{

            conn = DataBase.getConnection();
            ps = conn.prepareStatement(
                "UPDATE seller " + 
                "SET BaseSalary = BaseSalary + ? "+
                "WHERE " +
                "(DepartmentId = ?)"
            );

            ps.setDouble(1, 200);
            ps.setInt(2, 2);

            int rowsAffected = ps.executeUpdate();
            System.out.println("Done! Rows Affected: " + rowsAffected);

        }catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            DataBase.closeConnection();
            DataBase.closeStatement(ps);
        }
    }
}
