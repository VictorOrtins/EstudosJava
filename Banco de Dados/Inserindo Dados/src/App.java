import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.sql.Date;

import Database.DataBase;

public class App {
    public static void main(String[] args) throws Exception {
        Connection conn = null;
        PreparedStatement st = null;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try{
            conn = DataBase.getConnection();

            st = conn.prepareStatement(
                "INSERT INTO seller " + 
                "(Name, Email, BirthDate, BaseSalary, DepartmentId) " + 
                "VALUES " + 
                "(?,?,?,?,?)",
                Statement.RETURN_GENERATED_KEYS
            );

            //O parameterIndex indica a INTERROGAÇÃO da query.
            //Então, nesse caso, eu estou setando a primeira interrogação da statement
            st.setString(1, "Carl Purple");

            st.setString(2, "carl@gmail.com");
            st.setDate(3, new Date(sdf.parse("22/04/1985").getTime()));
            st.setDouble(4, 3000);
            st.setInt(5, 4);

            // st = conn.prepareStatement("INSERT INTO department (Name) values ('D1'),('D2')", Statement.RETURN_GENERATED_KEYS);

            int rowsAffected = st.executeUpdate();
            if(rowsAffected > 0){
                ResultSet rs = st.getGeneratedKeys();
                while(rs.next()){
                    int id = rs.getInt(1);
                    System.out.println("Done! ID = " + id);
                }
            }else{
                System.out.println("No row affected");
            }
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
