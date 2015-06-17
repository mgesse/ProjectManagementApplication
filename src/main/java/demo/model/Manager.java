package demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by poo2 on 17/06/2015.
 */
@Entity
@PrimaryKeyJoinColumn(name="id")
public class Manager extends Employee {
    public Double getBonusSuccess() {
        return bonusSuccess;
    }

    public void setBonusSuccess(Double bonusSuccess) {
        this.bonusSuccess = bonusSuccess;
    }

    @Column
    private Double bonusSuccess;

    //ArrayList = pot haver duplicats
    //Hashsets = no pot haver duplicats

    //one manager for many projects El manager ha de tenir el mateix nom que la variable del ManyToOne de la classe relacionada
    @OneToMany(mappedBy = "manager")
    private Set<Project> projects = new HashSet<>();

    public Manager(){

    }

    @Override
    public String toString() {
        return "Manager{" +
                "bonusSuccess=" + bonusSuccess +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Manager manager = (Manager) o;

        return !(bonusSuccess != null ? !bonusSuccess.equals(manager.bonusSuccess) : manager.bonusSuccess != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (bonusSuccess != null ? bonusSuccess.hashCode() : 0);
        return result;
    }
}
