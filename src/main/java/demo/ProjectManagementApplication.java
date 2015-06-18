package demo;

import demo.service.EmployeeService;
import demo.service.ManagerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ProjectManagementApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(ProjectManagementApplication.class, args);

        EmployeeService employeeService = context.getBean(EmployeeService.class);
        employeeService.testEmployees();
        employeeService.testDevelopers();
        //employeeService.testManagers();
        //employeeService.consultes();
        ManagerService managerService = context.getBean(ManagerService.class);
        managerService.testManagers();
    }
}
