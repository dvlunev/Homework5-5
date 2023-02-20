package hw55.dao;

import hw55.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeDao {

    void createOrUpdateEmployee(Employee employee);
    Optional<Employee> getEmployeeById(long id);
    List<Employee> getAllEmployeeList();
    void deleteEmployee(Employee employee);
}
