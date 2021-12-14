package galip.hrms.dataAcces.abstracts;

import galip.hrms.entities.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployerDao extends JpaRepository<Employer,Integer> {
    public List<Employer> findAll();
}
