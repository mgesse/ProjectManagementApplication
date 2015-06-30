package demo.controller;

import demo.exception.DeveloperException;
import demo.model.Developer;
import demo.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by poo2 on 29/06/2015.
 */
@RestController //Li diu que serà per implementar un controlador
@RequestMapping("/developers")  //URL relatica per accedir al controlador.
public class developerController {

    @Autowired
    private DeveloperRepository developerRepository;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Developer save(@RequestBody Developer developer){
        return developerRepository.save(developer);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Developer> findAll(){
        List<Developer> developers = new ArrayList<Developer>();
        Iterator<Developer> iterator = developerRepository.findAll().iterator();

        while(iterator.hasNext()){
            developers.add(iterator.next());
        }

        return developers;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Developer getById(@PathVariable Long id){
        Developer developer = developerRepository.findOne(id);

        if(developer == null){
            throw new DeveloperException(id);
        }

        return developer;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id){
        Developer developer = developerRepository.findOne(id);

        if(developer == null){
            throw new DeveloperException(id);
        }

        developerRepository.delete(id); //Torna per defecte el 200-OK
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Developer updateById(@PathVariable Long id, @RequestBody Developer newDeveloper){
        Developer developer = developerRepository.findOne(id);

        if(developer == null){
            throw new DeveloperException(id);
        }

        newDeveloper = developerRepository.save(newDeveloper); //Torna l'objecte actualitzat quan desa!
        return newDeveloper;
    }

}
