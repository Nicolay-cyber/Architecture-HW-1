package structural_patterns.composite;

import java.util.ArrayList;

public class Organization {
    ArrayList<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public float getNetSalaries() {
        float netSalary = 0;
        for (Employee employee: employees) {
            netSalary += employee.getSalary();
        }
        return netSalary;
    }
}
