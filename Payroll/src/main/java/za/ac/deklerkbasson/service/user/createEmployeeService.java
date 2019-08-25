package za.ac.deklerkbasson.service.user;

import za.ac.deklerkbasson.domain.demography.Gender;
import za.ac.deklerkbasson.domain.demography.Race;
import za.ac.deklerkbasson.domain.user.Employee;

public interface createEmployeeService {

    Employee saveEmployee(String empID, String empName, String empSurname, int empAge, String gender, String race);
    Gender getEmployeeGender(String id);
    Race getEmployeeRace(String id);
}
