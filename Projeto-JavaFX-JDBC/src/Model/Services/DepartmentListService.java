package Model.Services;

import java.util.ArrayList;
import java.util.List;

import Model.Entities.Department;

public class DepartmentListService {
    public List<Department> findAll(){
        List<Department> list = new ArrayList<Department>();
        list.add(new Department(1, "Books"));
        list.add(new Department(2, "Computers"));
        list.add(new Department(3, "Teste"));

        return list;
    }

    public static DepartmentListService instantiateDepartmentService(){
        return new DepartmentListService();
    }
}
