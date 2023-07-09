package dev.knowledgecafe.spring_monitoring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @DurationMetrics
    @GetMapping("/employee")
    public String getEmployeeName(@RequestParam("id") Integer id){
    String employeeName = employeeService.getEmployeeName(id);

    return ((employeeName != null) ? employeeName : "No Employee Found");
    }

}
