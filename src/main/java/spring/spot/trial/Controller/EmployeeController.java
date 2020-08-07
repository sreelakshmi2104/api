package spring.spot.trial.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.spot.trial.Entity.Employee;
import spring.spot.trial.Service.EmployeeService;
import spring.spot.trial.dto.ManagerDTO;

import java.util.List;
@RequestMapping
@RestController
@CrossOrigin("*")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String helloController() {
        return "Hey the Application is running on port 8081";
    }


    @GetMapping("/employee")
    public List<Employee> getAllEmployee() {
        return (List<Employee>) employeeService.getAllEmployee();
    }


    @GetMapping(value = "/employee/{id}")
    public List<Employee> getEmployeeById(@PathVariable("id") String id) {
        return employeeService.getEmployeeById(id);
    }

   @GetMapping (value="/employee/{id}/{firstName}")

    public Employee findByKeyFirstName(@PathVariable("id") String id, @PathVariable("firstName") String firstName){
        return employeeService.findByKeyFirstName(id, firstName);
    }

    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee emp) {
        return employeeService.createEmployee(emp);
    }


    @PutMapping(value = "/employee/{id}")
    public Employee UpdateEmployeeById(@PathVariable("id") String id, @RequestBody Employee emp) {
        return employeeService.updateEmployeeById(id,emp);
    }

    @GetMapping("/manager/{id}")
    public ManagerDTO getManager(@PathVariable("id") String id){
        return employeeService.getManagerDetails(id);
    }

}
