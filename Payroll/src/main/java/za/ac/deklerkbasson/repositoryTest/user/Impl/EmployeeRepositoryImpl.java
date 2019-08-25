package za.ac.deklerkbasson.repositoryTest.user.Impl;

import org.springframework.stereotype.Repository;
import za.ac.deklerkbasson.domain.user.Employee;
import za.ac.deklerkbasson.repositoryTest.user.EmployeeRepository;

import java.util.*;

@Repository("InMemory")
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private static EmployeeRepositoryImpl repository = null;
    private static EmployeeRepositoryImpl employeeRepositoryImpl = null;
    private Map<String, Employee> employeess;

    private EmployeeRepositoryImpl() {
        this.employeess = new HashMap<>();
    }

    public static EmployeeRepositoryImpl getEmployeeRepositoryImpl() {
        if (employeeRepositoryImpl == null) {
            employeeRepositoryImpl = new EmployeeRepositoryImpl();
        }
        return employeeRepositoryImpl;
    }

    public Employee create(Employee employee) {
        this.employeess.put(employee.getEmployeeID(), employee);
        return employee;
    }

    public Employee read(String employeeId) {
        return this.employeess.get(employeeId);
    }

    public Employee update(Employee employee) {
        this.employeess.replace(employee.getEmployeeID(), employee);
        return this.employeess.get(employee.getEmployeeID());
    }

    public void delete(String employeeId) {
        this.employeess.remove(employeeId);
    }

    public Set<Employee> getAll() {
        Collection<Employee> students = this.employeess.values();
        Set<Employee> set = new HashSet<>();
        set.addAll(students);
        return set;
    }
}

