public class Employee implements Comparable<Employee>{
    private String name;
    private Double salary;

    public Employee(String name, Double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return this.salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Name = " + this.getName() + " --- Salary = " + this.getSalary();
    }

    @Override
    public int compareTo(Employee other) {
        return - this.salary.compareTo(other.getSalary()); //O - é pra comparar de forma decrescente
    }
}


