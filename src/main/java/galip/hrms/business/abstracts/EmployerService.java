package galip.hrms.business.abstracts;

import galip.hrms.core.utilities.results.DataResult;
import galip.hrms.core.utilities.results.Result;
import galip.hrms.entities.concretes.Employer;

import java.util.List;

public interface EmployerService {
    public DataResult<List<Employer>> getAllEmployers();
    public Result addEmployer(Employer employer);
}
