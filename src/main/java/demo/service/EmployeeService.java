package demo.service;

import demo.model.Category;
import demo.model.Developer;
import demo.model.Employee;
import demo.model.Manager;
import demo.repository.DeveloperRepository;
import demo.repository.EmployeeRepositori;
import demo.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by poo2 on 16/06/2015.
 */
@Service
public class EmployeeService {
    //Hem autoinjectat el repositori de servei, instancia un objecte en temps d'execució.
    @Autowired
    private EmployeeRepositori employeeRepositori;
    @Autowired
    private DeveloperRepository developerRepository;
    @Autowired
    private ManagerRepository managerRepository;

    public void testEmployees(){
        System.out.println("hola?");

        Calendar calendar = Calendar.getInstance(); //Facthory Method (Mètode estàtic que serveix per a construir objectes)
        calendar.set(2015, Calendar.JANUARY, 1);
        Date startDate = calendar.getTime();

        calendar.set(2015, Calendar.MARCH, 1);
        Date endDate = calendar.getTime();

        calendar.set(2015, Calendar.FEBRUARY, 1);
        Date dateIncorporation = calendar.getTime();

        Employee employee = new Employee();
        employee.setName("Miquel");
        employee.setSurname("Gessé");
        employee.setSalary(1500.0);
        employee.setStartDate(new Date());

        //Desem l'objecte
        employeeRepositori.save(employee);

        Employee employee2 = new Employee();
        employee2.setName("John");
        employee2.setSurname("Doe");
        employee2.setSalary(1400.0);
        employee2.setStartDate(dateIncorporation);

        //Desem l'objecte
        employeeRepositori.save(employee2);

        Employee employee3 = new Employee();
        employee3.setName("Pim");
        employee3.setSurname("Gessé");
        employee3.setSalary(1000.0);
        employee3.setStartDate(new Date());

        //Desem l'objecte
        employeeRepositori.save(employee3);
        //Guarda a "gesse" el resultat de cercar pel cognom Gesse i obté la posició 0 de la llista.
        Employee gesse = employeeRepositori.findBySurname("Gessé").get(0);
        Employee pum = employeeRepositori.findBySurname("Gessé").get(1);    //No hauria de sortir cap... No hi ha repetits, entenc

        Employee oratge = employeeRepositori.findByStartDateBetween(startDate,endDate).get(0);

        //System.out.println(gesse);
        //System.out.println(pum);
        //Employee pep = employeeRepositori.findBySalaryEquals(1400.0).get(0);
        //System.out.println(pep);

        System.out.println(oratge);


    }

    public void testDevelopers(){
        Developer desenvolupador1 = new Developer();
        desenvolupador1.setName("Miquel");
        desenvolupador1.setSurname("Gessé");
        desenvolupador1.setSalary(1800.0);
        desenvolupador1.setStartDate(new Date());
        desenvolupador1.setCategory(Category.ARCHITECT);
        developerRepository.save(desenvolupador1);

        Developer desenvolupador2 = new Developer();
        desenvolupador2.setName("Jaume");
        desenvolupador2.setSurname("Primer");
        desenvolupador2.setSalary(1700.0);
        desenvolupador2.setStartDate(new Date());
        desenvolupador2.setCategory(Category.SENIOR);
        developerRepository.save(desenvolupador2);

        Developer desenvolupador3 = new Developer();
        desenvolupador3.setName("Pim");
        desenvolupador3.setSurname("Pam");
        desenvolupador3.setSalary(1600.0);
        desenvolupador3.setStartDate(new Date());
        desenvolupador3.setCategory(Category.JUNIOR);
        developerRepository.save(desenvolupador3);

    }

    public void testManagers(){
        Manager coord1 = new Manager();
        coord1.setName("Pau");
        coord1.setSurname("Pou");
        coord1.setSalary(2000.0);
        coord1.setStartDate(new Date());
        coord1.setBonusSuccess(2.0);
        managerRepository.save(coord1);

        Manager coord2 = new Manager();
        coord2.setName("Marta");
        coord2.setSurname("Pot");
        coord2.setSalary(6000.0);
        coord2.setStartDate(new Date());
        coord2.setBonusSuccess(9.0);
        managerRepository.save(coord2);
    }

    public void testProject(){

    }

    public void consultes(){

        Manager managerListSearch = managerRepository.findByBonusSuccessGreaterThan(5.0).get(0);
        System.out.println(managerListSearch);

        Employee con1 = employeeRepositori.findBySurname("Pot").get(0);
        System.out.println(con1);
    }


}
