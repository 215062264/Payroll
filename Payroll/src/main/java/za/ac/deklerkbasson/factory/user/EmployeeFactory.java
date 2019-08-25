package za.ac.deklerkbasson.factory.user;

import za.ac.deklerkbasson.domain.user.Employee;
import za.ac.deklerkbasson.util.Misc;

public class EmployeeFactory {

    public static Employee buildEmployee(String firstName, String lastName, int age) {
        return new Employee.Builder().age(age).employeeFirstName(firstName).employeeLastName(lastName).employeeId(Misc.generateId()).build();
    }
}
