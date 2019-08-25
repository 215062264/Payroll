package za.ac.deklerkbasson.service.user.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.deklerkbasson.domain.user.Employee;
import za.ac.deklerkbasson.repositoryTest.user.EmployeeRepository;
import za.ac.deklerkbasson.service.user.EmployeeService;

import java.util.Set;

@Service("ServiceImpl")
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    @Override
    public Employee create(Employee employee) {
        return repository.create(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return repository.update(employee);
    }

    @Override
    public void delete(String s) {
        repository.delete(s);
    }

    @Override
    public Employee read(String s) {
        return repository.read(s);
    }


    @Override
    public Set<Employee> getAll() {
        return repository.getAll();
    }
}

