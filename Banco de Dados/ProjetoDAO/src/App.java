import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

import Dao.SellerDaoJDBC;
import Database.DataBase;
import Entities.Department;
import Entities.Seller;
import Factory.DaoFactory;
import Interfaces.Dao;

public class App {
    public static void main(String[] args) throws Exception {

        Connection conn = null;
        conn = DataBase.getConnection();
        
        System.out.println("=== TESTE 1 - findById Seller ===");
        Dao<Seller> dao = DaoFactory.createSellerDao(conn);
        Seller seller = dao.findById(3);
        System.out.println(seller);

        System.out.println("\n === TESTE 2 - findById Department ===");
        Dao<Department> dao2 = DaoFactory.createDepartmentDao(conn);
        System.out.println(dao2.findById(2));

        System.out.println("\n === TESTE 3 - find(Seller)ByDepartmentId === ");
        List<Seller> list = ((SellerDaoJDBC) dao).findByDepartmentId(2);
        for(Seller sel : list){
            System.out.println(sel);
        }

        System.out.println("\n === TESTE 4 - findAll Seller === ");
        List<Seller> list2 = dao.findAll();
        for(Seller sel : list2){
            System.out.println(sel);
        }
        
        System.out.println("\n === TESTE 5 - findAll Department ===");
        List<Department> list3 = dao2.findAll();
        for(Department dep : list3){
            System.out.println(dep);
        }

        System.out.println("\n === TESTE 6 - insert Seller === ");
        Seller seller2 = new Seller(null, "Yaremchuck", "yaremchuk@gmail.com", LocalDate.now(), 2520.87, new Department(4, "Books"));
        dao.insert(seller2);

        System.out.println("\n === TESTE 7 - insert Department === ");
        Department department = new Department(null, "E-comemrce");
        dao2.insert(department);

        System.out.println("\n === TESTE 8 - update Seller ===");
        seller2.setBaseSalary(40000.21);
        dao.update(seller2);

        System.out.println("\n === TESTE 9 - update Department ===");
        department.setName("Games");
        dao2.update(department);

        System.out.println("\n === TESTE 10 - delete Seller === ");
        dao.deleteById(10);

        // System.out.println("\n === TESTE 11 - delete Department ===");
        // dao2.deleteById(2);
        //O delete department aparentemente deu algum erro que está acima do meu conhecimento de banco de dados



    
    }
}
