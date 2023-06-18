import java.util.ArrayList;
import java.util.List;

public class Worker {
    private String name;
    private WorkerLevel workerLevel;
    private Double baseSalary;
    private Department department;
    private List<HourContract> contracts;

    public Worker(){
        this.name = null;
        this.workerLevel = null;
        this.baseSalary = null;
        this.department = null;
        this.contracts = new ArrayList<HourContract>();
    }

    public Worker(String name, double baseSalary){
        this.name = name;
        this.baseSalary = baseSalary;

        this.workerLevel = null;
        this.department = null;
        this.contracts = new ArrayList<HourContract>();
    }

    public Worker(String name, WorkerLevel workerLevel, double baseSalary, Department department, List<HourContract> contracts){
        this.name = name;
        this.workerLevel = workerLevel;
        this.baseSalary = baseSalary;
        this.department = department;
        this.contracts = contracts;
    }

    public void addContract(HourContract contract){
        this.contracts.add(contract);
    }

    public void removeContract(HourContract contract){
        this.contracts.remove(contract);
    }

    public double income(int year, int month){
        double income_value = baseSalary;

        for(HourContract contract: contracts){
            if(contract.getDate().getMonth().getValue() == month && contract.getDate().getYear() == year){
                income_value += contract.totalValue();
            } 
        }


        return income_value;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getWorkerLevel() {
        return this.workerLevel;
    }

    public void setWorkerLevel(WorkerLevel workerLevel) {
        this.workerLevel = workerLevel;
    }

    public double getBaseSalary() {
        return this.baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartment() {
        return this.department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<HourContract> getContracts() {
        return this.contracts;
    }
}
