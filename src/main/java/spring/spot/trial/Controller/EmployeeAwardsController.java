package spring.spot.trial.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.spot.trial.Entity.EmployeeAwards;
import spring.spot.trial.Service.EmployeeAwardsService;

import java.util.List;

/*Received*/

@CrossOrigin("*")
@RequestMapping
@RestController
public class EmployeeAwardsController {
    @Autowired
    EmployeeAwardsService employeeAwardsService;

    public EmployeeAwardsController(EmployeeAwardsService employeeAwardsService) {
        this.employeeAwardsService = employeeAwardsService;
    }

    @GetMapping("/employee/employeeawards")
    public List<EmployeeAwards> getAllEmployeeAwards() {
        return (List<EmployeeAwards>) employeeAwardsService.getAllEmployeeAwards();
    }

    @GetMapping(value = "employee/{id}/employeeawards")
    public List<EmployeeAwards> getEmployeeAwardsById(@PathVariable("id") String id) {
        return employeeAwardsService.getEmployeeAwardsById(id);
    }

    @PostMapping("/employee/employeeawards")
    public EmployeeAwards createEmployeeAwards(@RequestBody EmployeeAwards emp) throws Exception {
        return employeeAwardsService.createEmployeeAwards(emp);
    }

    @PutMapping(value = "employee/{id}/employeeawards")
    public EmployeeAwards UpdateEmployeeAwardsById(@PathVariable("id") String id, @RequestBody EmployeeAwards emp) {
        return employeeAwardsService.updateEmployeeAwardsById(id,emp);
    }
}
