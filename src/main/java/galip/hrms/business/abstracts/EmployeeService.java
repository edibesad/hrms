package galip.hrms.business.abstracts;

import galip.hrms.core.utilities.results.DataResult;
import galip.hrms.core.utilities.results.Result;
import galip.hrms.entities.concretes.Employee;

import java.util.List;

public interface EmployeeService {
    public DataResult<List<Employee>> getAllEmployees();
    public Result addEmployee(Employee employee) throws Exception;
}
