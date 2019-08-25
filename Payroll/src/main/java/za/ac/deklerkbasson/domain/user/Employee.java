package za.ac.deklerkbasson.domain.user;

import java.util.Objects;

public class Employee {
    private String EmployeeID, EmployeeFirstName, EmployeeLastName;
    private int age;

    private Employee() {
    }

    private Employee(Builder builder) {
        this.EmployeeID = builder.employeeId;
        this.age = builder.age;
        this.EmployeeFirstName = builder.employeeFirstName;
        this.EmployeeLastName = builder.employeeLastName;
    }

    public String getEmployeeID() {
        return EmployeeID;
    }

    public String getEmployeeFirstName() {
        return EmployeeFirstName;
    }

    public String getEmployeeLastName() {
        return EmployeeLastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "EmployeeID='" + EmployeeID + '\'' +
                ", EmployeeFirstName='" + EmployeeFirstName + '\'' +
                ", EmployeeLastName='" + EmployeeLastName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return EmployeeID.equals(employee.EmployeeID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(EmployeeID);
    }

    public static class Builder {

        private String employeeId, employeeFirstName, employeeLastName;
        private int age;

        public Builder employeeId(String employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public Builder employeeFirstName(String employeeFirstName) {
            this.employeeFirstName = employeeFirstName;
            return this;
        }

        public Builder employeeLastName(String employeeLastName) {
            this.employeeLastName = employeeLastName;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder copy(Employee employee) {
            this.employeeId = employee.EmployeeID;
            this.employeeFirstName = employee.EmployeeFirstName;
            this.employeeLastName = employee.EmployeeLastName;
            this.age = employee.age;

            return this;
        }

        public Employee build() {
            return new Employee(this);
        }

    }
}
