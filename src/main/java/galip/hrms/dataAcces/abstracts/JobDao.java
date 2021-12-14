package galip.hrms.dataAcces.abstracts;
import galip.hrms.entities.concretes.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobDao extends JpaRepository<Job, Integer> {
//    List<Job> getAll();
}
