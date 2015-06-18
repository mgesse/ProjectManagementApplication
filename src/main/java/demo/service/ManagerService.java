package demo.service;

import demo.model.Manager;
import demo.model.Project;
import demo.repository.ManagerRepository;
import demo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by poo2 on 18/06/2015.
 */
@Service
public class ManagerService {
    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private ProjectRepository projectRepository;

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

        Manager manager3 = new Manager();
        manager3.setName("Vegeta");
        manager3.setSurname("SSJJ4");
        manager3.setSalary(10000.0);
        manager3.setStartDate(new Date());
        manager3.setBonusSuccess(200.0);

        managerRepository.save(manager3);

        System.out.println("### CONSULTA por NAME and SURNAME ###");

        for (Manager maux : managerRepository.findByBonusSuccessGreaterThan(5.0)){
            System.out.println(maux);
        }

        //Fem un projecte nou...
        Project p=new Project();
        p.setDescription("Proyecto PUE");
        p.setEndDate(new Date(115,12,20));
        p.setStartDate(new Date());
        projectRepository.save(p);

        p.setManager(manager3); //Assignem el Manager 3 al projecte

        projectRepository.save(p);
        // System.out.println("### CONSULTA por PROJECTS/MANAGER ###");


    }
}
