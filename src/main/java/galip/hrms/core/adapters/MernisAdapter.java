package galip.hrms.core.adapters;

import galip.hrms.core.utilities.mernisReference.CFKKPSPublicSoap;
import galip.hrms.entities.concretes.Employee;

public class MernisAdapter {
    CFKKPSPublicSoap client = new CFKKPSPublicSoap();
    public boolean vaildate(Employee employee) throws Exception {
        return client.TCKimlikNoDogrula(Long.parseLong(employee.getNationalIdentityNumber()), employee.getName(), employee.getSurname(), employee.getYearOfBirth());
    }
}
