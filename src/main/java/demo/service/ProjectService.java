package demo.service;

import demo.model.Developer;
import demo.model.Manager;
import demo.model.Project;
import demo.repository.DeveloperRepository;
import demo.repository.ManagerRepository;
import demo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by poo2 on 25/06/2015.
 */
@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private DeveloperRepository developerRepository;

    @Autowired
    private ManagerRepository managerRepository;


    //public void addProject(Long idProject, Long idDeveloper){
    public void addProject(){
        //Especifiquem data inici i data final.
        Calendar calendar = Calendar.getInstance();
        calendar.set(2015, Calendar.MARCH, 1);
        Date dataInici = calendar.getTime();
        calendar.set(2015, Calendar.JULY, 1);
        Date dataFinal = calendar.getTime();

        Project project = new Project();

        project.setDescription("Prova Projecte 1");
        project.setStartDate(dataInici);
        project.setEndDate(dataFinal);

        //Especifiquem el manager
        Manager manager = managerRepository.findByNameAndSurname("Pau","Pou").get(0);

        project.setManager(manager);

        //Especifiquem els desenvolupadors
        Developer desenvolupador = developerRepository.findByNameAndSurname("Jaume","Primer").get(0);
        project.getDevelopers().add(desenvolupador);

        projectRepository.save(project);

        //Project project = projectRepository.findOne(idProject);
        //return null;
    }

    /*public Project test(){
        Project pj = new Project();
        pj.setDescription("...");

        Developer dv = new Developer();
        dv.setName("---");

        //projectRepository.save(pj);
        developerRepository.save(dv);

        pj.getDevelopers();

    }*/


}


