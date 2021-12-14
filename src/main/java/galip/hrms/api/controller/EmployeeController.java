package galip.hrms.api.controller;

import galip.hrms.business.abstracts.EmployeeService;
import galip.hrms.core.utilities.results.DataResult;
import galip.hrms.core.utilities.results.Result;
import galip.hrms.entities.concretes.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/getAllEmployees")
    public DataResult<List<Employee>> getAllEmployees() {
        return this.employeeService.getAllEmployees();
    }

    @PostMapping("/getAllEmployees")
    public Result addEmployee(@RequestBody Employee employee) throws Exception {
        return this.employeeService.addEmployee(employee);
    }


}
