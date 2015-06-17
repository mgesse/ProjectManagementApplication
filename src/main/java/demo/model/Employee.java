package demo.model;

import javax.persistence.*;
import java.util.Date;


/**
 * Created by poo2 on 15/06/2015.
 */
@Entity //Servirà per a BBDD
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee {
    @Id     //CAMP ID del camp de sota
    @GeneratedValue(strategy = GenerationType.AUTO)     //Defineix l'estratègia per a treballar amb el llenguatge del SBGB al que ens connectem. El realitza de manera AUTO en funció de les preferències del SGBD
    protected Long id;
    private String name;
    private String surname;
    private Double salary;
    @Temporal(TemporalType.DATE)
    private Date startDate;

    public Employee(String name, String surname, Double salary, Date startDate) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.startDate = startDate;
    }

    public Employee() {

    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                ", startDate=" + startDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (!id.equals(employee.id)) return false;
        if (!name.equals(employee.name)) return false;
        if (!surname.equals(employee.surname)) return false;
        if (!salary.equals(employee.salary)) return false;
        return startDate.equals(employee.startDate);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + salary.hashCode();
        result = 31 * result + startDate.hashCode();
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }


}
