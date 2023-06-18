import java.util.List;
import java.util.function.Predicate;

public class EmployeeService {
    public static double filteredSum(List<? extends Employee> list, Predicate<Employee> criteria){
        double sum = 0.0;
        for(Employee employee : list){
            if(criteria.test(employee)){
                sum += employee.getSalary();
            }
        }

        return sum;
    }
}
