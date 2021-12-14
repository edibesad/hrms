package galip.hrms.dataAcces.abstracts;

import galip.hrms.entities.concretes.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {
    public List<Employee> findAll();
}
