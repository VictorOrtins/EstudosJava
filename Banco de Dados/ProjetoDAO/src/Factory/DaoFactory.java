package Factory;

import java.sql.Connection;

import Dao.DepartmentDaoJDBC;
import Dao.SellerDaoJDBC;
import Entities.Department;
import Entities.Seller;
import Interfaces.Dao;

public class DaoFactory {
    public static Dao<Seller> createSellerDao(Connection conn){
        return new SellerDaoJDBC(conn);
    }
    
    public static Dao<Department> createDepartmentDao(Connection conn){
        return new DepartmentDaoJDBC(conn);
    }
}
