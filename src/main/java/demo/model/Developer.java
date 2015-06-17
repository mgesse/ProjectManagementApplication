package demo.model;

import javax.persistence.*;

/**
 * Created by poo2 on 17/06/2015.
 */

@Entity
@PrimaryKeyJoinColumn(name="id")    //La unim pel camp ID
public class Developer extends Employee{
    @Column
    @Enumerated(EnumType.STRING)
    private Category category;

    //Totes les entitats han de tenir un constructor buit, ja que al iniciar-se, pot construir l'objecte al recuperar de la BBDD
    public Developer() {

    }

    public Category getCategory(){
        return category;
    }

    public void setCategory(Category category){
        this.category = category;
    }

    @Override
    public String toString() {
        String developer = super.toString();
        return developer + "Developer{" +
                "category=" + category +
                '}';
    }
}
