package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Database.DataBase;
import Database.exceptions.DbException;
import Entities.Department;
import Entities.Seller;
import Interfaces.Dao;

public class SellerDaoJDBC implements Dao<Seller>{

    private Connection conn = null;

    public SellerDaoJDBC(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(Seller obj) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            ps = conn.prepareStatement("INSERT INTO seller " + 
            "(Name, Email, BirthDate, BaseSalary, DepartmentId) " + 
            "VALUES " + 
            "(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, obj.getName());
            ps.setString(2, obj.getEmail());
            ps.setDate(3, Date.valueOf(obj.getBirthDate()));
            ps.setDouble(4, obj.getBaseSalary());
            ps.setInt(5, obj.getDepartment().getId());

            int rowsAffected = ps.executeUpdate();

            if(rowsAffected <= 0){
                throw new DbException("Error! Unable to insert object from class " + obj.getClass());
            }

            rs = ps.getGeneratedKeys();
            if(rs.next()){
                obj.setId(rs.getInt(1));
            }
        }
        catch(SQLException e){
            throw new DbException(e.getMessage());
        }
        finally{
            DataBase.closeResultSet(rs);
            DataBase.closeStatement(ps);
        }
    }

    @Override
    public void update(Seller obj) {
        PreparedStatement ps = null;

        try{
            ps = conn.prepareStatement("UPDATE seller " + 
            "SET Name = ?, Email = ?, BirthDate = ?, BaseSalary = ?, DepartmentId = ? " + 
            "WHERE Id = ?");

            ps.setString(1, obj.getName());
            ps.setString(2, obj.getEmail());
            ps.setDate(3, Date.valueOf(obj.getBirthDate()));
            ps.setDouble(4, obj.getBaseSalary());
            ps.setInt(5, obj.getDepartment().getId());
            ps.setInt(6, obj.getId());

            int rowsAffected = ps.executeUpdate();
            if(rowsAffected <= 0){
                throw new DbException("Error! Unable to update object from class " + obj.getClass());
            }
        }
        catch(SQLException e){
            throw new DbException(e.getMessage());
        }
        finally{
            DataBase.closeStatement(ps);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement ps = null;

        try{
            ps = conn.prepareStatement("DELETE FROM seller WHERE Id = ?");

            ps.setInt(1, id);

            ps.executeUpdate();
        }   
        catch(SQLException e){
            throw new DbException(e.getMessage());
        }
        finally{
            DataBase.closeStatement(ps);
        }
    }

    @Override
    public Seller findById(Integer id) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            ps = conn.prepareStatement("SELECT seller.*,department.Name as DepName " + 
                                        "FROM seller INNER JOIN department " + 
                                        "ON seller.DepartmentId = department.Id " + 
                                        "WHERE seller.Id = ?");

            ps.setInt(1, id);
            rs = ps.executeQuery();

            if(!rs.next()){
                return null;
            }

            Department department = new Department(rs.getInt("DepartmentId"),rs.getString("DepName") );

            Seller seller = new Seller(rs.getInt("Id"), rs.getString("Name"), 
                                        rs.getString("Email"), rs.getDate("BirthDate").toLocalDate(), 
                                        rs.getDouble("BaseSalary"), department);


            return seller;
        }
        catch(SQLException e){
            throw new DbException(e.getMessage());
        }
        finally{
            DataBase.closeResultSet(rs);
            DataBase.closeStatement(ps);
        }
    }

    @Override
    public List<Seller> findAll() {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            ps = conn.prepareStatement("SELECT seller.*,department.Name as DepName " + 
                                        "FROM seller INNER JOIN department " + 
                                        "ON seller.DepartmentId = department.Id " + 
                                        "ORDER BY Name");

            rs = ps.executeQuery();

            Seller tempSeller;
            Department tempDepartment;

            List<Seller> list = new ArrayList<Seller>();

            Map<Integer, Department> map = new HashMap<Integer,Department>();

            while(rs.next()){
                int depId = rs.getInt("DepartmentId");

                if(map.get(depId) == null){
                    tempDepartment = new Department(rs.getInt("DepartmentId"), rs.getString("DepName"));
                    map.put(tempDepartment.getId(), tempDepartment);
                }
                else{
                    tempDepartment = map.get(depId);
                }

                tempSeller = new Seller(rs.getInt("Id"), rs.getString("Name"), rs.getString("Email"), rs.getDate("BirthDate").toLocalDate(), rs.getDouble("BaseSalary"), tempDepartment);
                list.add(tempSeller);
            }

            return list;
        }  
        catch(SQLException e){
            throw new DbException(e.getMessage());
        }
        finally{
            DataBase.closeResultSet(rs);
            DataBase.closeStatement(ps);
        }
    }

    public List<Seller> findByDepartmentId(int departmentId){

        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            ps = conn.prepareStatement("SELECT seller.*,department.Name as DepName " + 
            "FROM seller INNER JOIN department " + 
            "ON seller.DepartmentId = department.Id " + 
            "WHERE DepartmentId = ? " + 
            "ORDER BY Name");

            ps.setInt(1, departmentId);
            rs = ps.executeQuery();

            // if(!rs.next()){
            //     System.out.println("teste next");
            //     return null;
            // }

            
            Department department;

            Seller tempSeller;
            List<Seller> list = new ArrayList<Seller>();

            if(rs.next()){
                department =  new Department(rs.getInt("DepartmentId"), rs.getString("DepName"));
                tempSeller = new Seller(rs.getInt("Id"), rs.getString("Name"), 
                                        rs.getString("Email"), rs.getDate("BirthDate").toLocalDate(),
                                        rs.getDouble("BaseSalary"), department);

                list.add(tempSeller);
            }
            else{
                return null;
            }
            
            while(rs.next()){
                tempSeller = new Seller(rs.getInt("Id"), rs.getString("Name"), 
                                        rs.getString("Email"), rs.getDate("BirthDate").toLocalDate(),
                                        rs.getDouble("BaseSalary"), department);

                list.add(tempSeller);
            }

            return list;
        }
        catch(SQLException e){
            throw new DbException(e.getMessage());
        }
        finally{
            DataBase.closeResultSet(rs);
            DataBase.closeStatement(ps);
        }
    }
    
}
