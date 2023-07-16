package dev.knowledgecafe.spring_monitoring;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class EmployeeController {

    EmployeeService employeeService;

    private final MeterRegistry registry;

    public EmployeeController(MeterRegistry registry, EmployeeService employeeService) {
        this.registry = registry;
        this.employeeService = employeeService;
    }

    @Timed(value="getEmployeeName.duration", description="Response time of getEmployeeName endpoint")
    @GetMapping("/employee")
    public String getEmployeeName(@RequestParam("id") Integer id){
        String employeeName = employeeService.getEmployeeName(id);
        return ((employeeName != null) ? employeeName : "No Employee Found");
    }

}
