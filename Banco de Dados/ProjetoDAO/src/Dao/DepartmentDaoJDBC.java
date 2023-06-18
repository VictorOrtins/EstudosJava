package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Database.DataBase;
import Database.exceptions.DbException;
import Entities.Department;
import Interfaces.Dao;

public class DepartmentDaoJDBC implements Dao<Department>{

    private Connection conn = null;

    public DepartmentDaoJDBC(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(Department obj) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{

            ps = conn.prepareStatement("INSERT INTO department " + 
            "(Name) " + 
            "VALUE " + 
            "(?)", Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, obj.getName());

            int rowsAffected = ps.executeUpdate();

            if(rowsAffected <= 0){
                throw new DbException("Error! Unable to insert object of class " + obj.getClass());
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
            DataBase.closeStatement(ps);;
            DataBase.closeResultSet(rs);
        }
    }

    @Override
    public void update(Department obj) {
        PreparedStatement ps = null;

        try{
            ps = conn.prepareStatement("UPDATE department SET Name = ? WHERE Id = ?");

            ps.setString(1, obj.getName());
            ps.setInt(2, obj.getId());

            int rowsAffected = ps.executeUpdate();

            if(rowsAffected <= 0){
                throw new DbException("Error! Unable to update object of class " + obj.getClass());
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
			ps = conn.prepareStatement(
				"DELETE FROM department WHERE Id = ?");

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
    public Department findById(Integer id) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            ps = conn.prepareStatement("SELECT seller.*,department.Name as DepName " + 
                                        "FROM seller INNER JOIN department " + 
                                        "ON seller.DepartmentId = department.Id " + 
                                        "WHERE DepartmentId = ? " + 
                                        "ORDER BY Name");

            ps.setInt(1, id);
            rs = ps.executeQuery();

            if(!rs.next()){
                return null;
            }

            Department department = new Department(rs.getInt("DepartmentId"),rs.getString("DepName") );

            return department;
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
    public List<Department> findAll() {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{    
            ps = conn.prepareStatement("Select * FROM department");
            rs = ps.executeQuery();

            Department tempDepartment;
            List<Department> list = new ArrayList<Department>();

            while(rs.next()){
                tempDepartment = new Department(rs.getInt("Id"), rs.getString("Name"));

                list.add(tempDepartment);
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
