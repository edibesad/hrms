package galip.hrms.business.concretes;


import galip.hrms.business.abstracts.JobService;
import galip.hrms.core.utilities.results.DataResult;
import galip.hrms.core.utilities.results.Result;
import galip.hrms.core.utilities.results.SuccessDataResult;
import galip.hrms.dataAcces.abstracts.JobDao;
import galip.hrms.entities.concretes.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("JobService")
public class JobManager implements JobService {
    private JobDao jobDao;

    @Autowired
    public JobManager(JobDao jobDao) {
        super();
        this.jobDao = jobDao;
    }

//    public DataResult getAll() {
//
//        return new SuccessDataResult(jobDao.getAll());
//    }

    public Result addJob(Job job) {
        return new SuccessDataResult( "Başarıyla Eklendi",job);

    }

}
