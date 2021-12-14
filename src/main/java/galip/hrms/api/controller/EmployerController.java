package galip.hrms.api.controller;

import galip.hrms.business.abstracts.EmployerService;
import galip.hrms.core.utilities.results.DataResult;
import galip.hrms.core.utilities.results.Result;
import galip.hrms.entities.concretes.Employer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employers")
public class EmployerController {
    EmployerService employerService;
    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping("/getAllEmployers")
    public DataResult getAllEmployers(){
        return this.employerService.getAllEmployers();
    }

    @PostMapping
    public Result addEmployer(@RequestBody Employer employer){
        return this.employerService.addEmployer(employer);
    }
}
