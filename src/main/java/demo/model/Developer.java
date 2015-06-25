package demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by poo2 on 17/06/2015.
 */

@Entity
@PrimaryKeyJoinColumn(name="id")    //La unim pel camp ID
public class Developer extends Employee{
    @Column
    @Enumerated(EnumType.STRING)
    private Category category;

    @JsonIgnore
    @ManyToMany(mappedBy = "developers")
    private Set<Project> projects = new HashSet<>();

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    //Totes les entitats han de tenir un constructor buit, ja que al iniciar-se, pot construir l'objecte al recuperar de la BBDD
    public Developer() {

    }

    public Category getCategory(){
        return category;
    }

    public void setCategory(Category category){
        this.category = category;
    }

    //Sols ha d'haver els atributs de la classe.
    @Override
    public String toString() {
        String developer = super.toString();
        return developer + "Developer{" +
                "category=" + category +
                '}';
    }
}
