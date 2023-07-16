package dev.knowledgecafe.spring_monitoring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class EmployeeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

   private static Map<Integer, String> employeeMap = new HashMap<>();
   static {
       employeeMap.put(1, "Employee One");
       employeeMap.put(2, "Employee Two");
       employeeMap.put(3, "Employee Three");
       employeeMap.put(4, "Employee Four");
       employeeMap.put(5, "Employee Five");
   }


    public String getEmployeeName(Integer employeeID){
        //Adding sleep
        int sleepTime = new Random().nextInt(500);// -- Uncomment the line if you want to add random delay

        try {
            TimeUnit.MILLISECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            LOGGER.error( e.getMessage());
        }
        return employeeMap.get(employeeID);
    }
}
