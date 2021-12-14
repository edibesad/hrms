package galip.hrms.api.controller;

import galip.hrms.business.abstracts.JobService;
import galip.hrms.core.utilities.results.Result;
import galip.hrms.entities.concretes.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    private JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        super();
        this.jobService = jobService;
    }
//    @GetMapping("/getall")
//    public DataResult getAll(){
//        return this.jobService.getAll();
//    }

    public Result addJob(@RequestBody Job job){
        return this.jobService.addJob(job);
    }
}
//30:44