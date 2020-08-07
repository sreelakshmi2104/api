package spring.spot.trial.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.trial.CertGenerate;
import spring.spot.trial.Entity.Employee;
import spring.spot.trial.Entity.EmployeeAwards;
import spring.spot.trial.Repository.EmployeeAwardsRepository;
import spring.spot.trial.Repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeAwardsService {
    @Autowired
    EmployeeAwardsRepository employeeAwardsRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    public EmployeeAwardsService(EmployeeAwardsRepository employeeAwardsRepository) { this.employeeAwardsRepository = employeeAwardsRepository; }

    public EmployeeAwards createEmployeeAwards(EmployeeAwards emp) throws Exception {
        EmployeeAwards employeeAwards = employeeAwardsRepository.save(emp);
        Employee employee = employeeRepository.findByEmpId(employeeAwards.getEmpId()).get(0);
        CertGenerate.certGenerate(employee,employeeAwards);

        return employeeAwards;
    }

    public List<EmployeeAwards> getAllEmployeeAwards() {
        return employeeAwardsRepository.findAll();
    }

    public List<EmployeeAwards> getEmployeeAwardsById(String id) { return employeeAwardsRepository.findByEmpId(id); }

    public EmployeeAwards updateEmployeeAwardsById(String id, EmployeeAwards emp) { return employeeAwardsRepository.save(emp); }

}
