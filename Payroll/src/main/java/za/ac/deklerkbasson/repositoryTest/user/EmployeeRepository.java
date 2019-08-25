package za.ac.deklerkbasson.repositoryTest.user;

import za.ac.deklerkbasson.domain.user.Employee;
import za.ac.deklerkbasson.repositoryTest.IRepository;

import java.util.Set;

public interface EmployeeRepository extends IRepository<Employee, String> {
    Set<Employee> getAll();
}
