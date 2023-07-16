package RestAPI.springbootbackend.controller;

import RestAPI.springbootbackend.exception.ResourceNotFoundException;
import RestAPI.springbootbackend.model.Employee;
import RestAPI.springbootbackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    //create Employee

    @PostMapping
    public Employee createEmployee( @RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    //Get employee by ID
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Employee employee=employeeRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Employee not exist with ID: "+ id));
        return ResponseEntity.ok(employee);

    }

    //update employee

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody  Employee employeeDetails){
        Employee updateEmployee=employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee not exist with ID: "+ id));
        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setSecondName(employeeDetails.getSecondName());
        updateEmployee.setEmailId(employeeDetails.getEmailId());
        employeeRepository.save(updateEmployee);
        return ResponseEntity.ok(updateEmployee);
    }

    //Delete Employee
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable Long id){
        Employee employee=employeeRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Employee not exist with ID: "+ id));
        employeeRepository.delete(employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
