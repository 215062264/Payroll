package za.ac.deklerkbasson.service.user.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import za.ac.deklerkbasson.domain.demography.Gender;
import za.ac.deklerkbasson.domain.demography.Race;
import za.ac.deklerkbasson.domain.user.Employee;
import za.ac.deklerkbasson.factory.demography.GenderFactory;
import za.ac.deklerkbasson.factory.demography.RaceFactory;
import za.ac.deklerkbasson.factory.user.EmployeeFactory;
import za.ac.deklerkbasson.repositoryTest.demography.Impl.GenderRepositoryImpl;
import za.ac.deklerkbasson.repositoryTest.demography.Impl.RaceRepositoryImpl;
import za.ac.deklerkbasson.repositoryTest.user.Impl.EmployeeRepositoryImpl;
import za.ac.deklerkbasson.service.user.createEmployeeService;

@ComponentScan
public class createEmployeeServiceImpl implements createEmployeeService {

    @Autowired
    public
    EmployeeRepositoryImpl empRepository = EmployeeRepositoryImpl.getEmployeeRepositoryImpl();
    @Autowired
    public
    GenderRepositoryImpl genderRepository = GenderRepositoryImpl.getGenderRepositoryImpl();
    @Autowired
    public
    RaceRepositoryImpl raceRepository = RaceRepositoryImpl.getRaceRepositoryImpl();
    @Autowired
    EmployeeFactory employeeFactory;
    @Autowired
    GenderFactory genderFactory;
    @Autowired
    RaceFactory raceFactory;

    public createEmployeeServiceImpl() {
    }

    @Override
    public Employee saveEmployee(String empID, String empName, String empSurname, int empAge, String empgender, String emprace) {
        Employee employee = this.empRepository.create(EmployeeFactory.buildEmployee(empName, empSurname, empAge));
        Gender gender = this.genderRepository.create(GenderFactory.buildGender(empgender));
        Race race = this.raceRepository.create(RaceFactory.buildRace(emprace));
        return employee;
    }


    @Override
    public Gender getEmployeeGender(String gender) {
        return this.genderRepository.read(gender);
    }

    @Override
    public Race getEmployeeRace(String race) {
        return this.raceRepository.read(race);
    }


}
