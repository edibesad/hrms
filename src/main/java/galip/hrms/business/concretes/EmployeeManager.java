package galip.hrms.business.concretes;

import galip.hrms.business.abstracts.EmployeeService;
import galip.hrms.core.adapters.MernisAdapter;
import galip.hrms.core.utilities.results.DataResult;
import galip.hrms.core.utilities.results.ErrorResult;
import galip.hrms.core.utilities.results.Result;
import galip.hrms.core.utilities.results.SuccessDataResult;
import galip.hrms.dataAcces.abstracts.EmployeeDao;
import galip.hrms.entities.concretes.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeManager implements EmployeeService {

    private MernisAdapter mernisAdapter = new MernisAdapter();
    private EmployeeDao employeeDao;

    public EmployeeManager(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public DataResult<List<Employee>> getAllEmployees() {
        return new SuccessDataResult("Data listelendi", this.employeeDao.findAll());
    }

    public Result addEmployee(Employee employee) throws Exception {

        if (employee.getName().isEmpty()||employee.getEmail().isEmpty()||employee.getSurname().isEmpty()||employee.getNationalIdentityNumber().isEmpty()||employee.getPassword().isEmpty())
            return new ErrorResult("Veriler Dolu olmalıdır");
        if(!employee.getPassword().equals(employee.getRepeatPassword()))
            return new ErrorResult("Şifreler Aynı olmalıdır.");
        if(!mernisAdapter.vaildate(employee))
            return new ErrorResult("Doğrulama Başarısız");

        employeeDao.save(employee);
        return new SuccessDataResult("Başarıyla Eklendi",employee);
    }
}
