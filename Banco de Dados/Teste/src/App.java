import java.sql.Connection;

import Database.DataBase;

public class App {
    public static void main(String[] args) throws Exception {
        Connection conn = DataBase.getConnection();
        DataBase.closeConnection();
    }
}
