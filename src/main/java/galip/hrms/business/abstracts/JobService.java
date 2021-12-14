package galip.hrms.business.abstracts;

import galip.hrms.core.utilities.results.Result;
import galip.hrms.entities.concretes.Job;
import org.springframework.stereotype.Service;

@Service
public interface JobService {
//    public DataResult getAll();
    public Result addJob(Job job);
}
