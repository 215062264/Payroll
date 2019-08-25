package za.ac.deklerkbasson.service.user;

import za.ac.deklerkbasson.domain.user.Employee;
import za.ac.deklerkbasson.service.IService;

import java.util.Set;

public interface EmployeeService extends IService<Employee, String> {
    Set<Employee> getAll();
}
