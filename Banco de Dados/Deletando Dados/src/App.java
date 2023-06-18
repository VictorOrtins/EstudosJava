import java.sql.Connection;
import java.sql.PreparedStatement;
import Database.DataBase;

public class App {
    public static void main(String[] args) throws Exception {
        Connection conn = null;
        PreparedStatement st = null;


        try{
            conn = DataBase.getConnection();

            st = conn.prepareStatement(
                "DELETE FROM department" + 
                "WHERE " + 
                "Id = ?"
            );

            st.setInt(1, 6);

            int rowsAffected = st.executeUpdate();
            System.out.println("Done! rowsAffected = " + rowsAffected);
                
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            DataBase.closeStatement(st);
            DataBase.closeConnection();
        }
    }
}
