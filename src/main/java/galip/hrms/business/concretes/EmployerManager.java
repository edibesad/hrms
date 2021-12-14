package galip.hrms.business.concretes;

import galip.hrms.business.abstracts.EmployerService;
import galip.hrms.core.utilities.results.ErrorResult;
import galip.hrms.core.utilities.results.Result;
import galip.hrms.core.utilities.results.SuccessDataResult;
import galip.hrms.dataAcces.abstracts.EmployerDao;
import galip.hrms.entities.concretes.Employer;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EmployerManager implements EmployerService {
    EmployerDao employerDao;
    Pattern emailPattern = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?");
    Matcher emailMatcher;
    public EmployerManager(EmployerDao employerDao) {
        this.employerDao = employerDao;
    }

    public SuccessDataResult getAllEmployers() {
        return new SuccessDataResult("Data Listelendi",employerDao.findAll());
    }

    public Result addEmployer(Employer employer) {
        emailMatcher = emailPattern.matcher(employer.getEmail());

        if (employer.getRepeatPassword().isEmpty()||employer.getEmail().isEmpty()||employer.getCompanyName().isEmpty()
                ||employer.getPhoneNumber().isEmpty()||employer.getPassword().isEmpty()||employer.getWebsite().isEmpty())
            return new ErrorResult("Veriler Dolu olmalıdır");

        if(!employer.getPassword().equals(employer.getRepeatPassword()))
            return new ErrorResult("Şifreler Aynı olmalıdır.");

        if (!emailMatcher.matches())
            return new ErrorResult("Girilen e-posta kurallara uymamaktadır");

        String emailDomain = employer.getEmail().substring(employer.getEmail().indexOf("@")+1);
        String websiteDomain = employer.getWebsite().substring((employer.getWebsite().indexOf("@")+1));

        if (!emailDomain.equals(websiteDomain))
            return new ErrorResult("E-posta ve Web Site domaini aynı olmalıdır.");

        employerDao.save(employer);
        return new SuccessDataResult("Kayıt yapıldı",employer);
    }
}

