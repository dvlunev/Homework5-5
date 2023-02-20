import hw55.dao.EmployeeDao;
import hw55.dao.impl.EmployeeDaoImpl;
import hw55.model.Employee;

public class Application {

    public static void main(String[] args) {

        EmployeeDao employeeDao = new EmployeeDaoImpl();

        employeeDao.createOrUpdateEmployee(new Employee("Andrei", "Andreev","male",29,3l));

        employeeDao.createOrUpdateEmployee(new Employee(24l,"Andrei", "Andreev","male",28,3l));

        System.out.println(employeeDao.getEmployeeById(3l));

        employeeDao.getAllEmployeeList().forEach(employee -> System.out.println(employee));

        employeeDao.deleteEmployee(new Employee(24l,"Andrei", "Andreev","male",28,3l));

        employeeDao.getAllEmployeeList().forEach(employee -> System.out.println(employee));
    }
}
