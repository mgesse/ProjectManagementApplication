package demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by poo2 on 17/06/2015.
 */
@Entity
public class Project {
    @Id             //CAMP ID del camp de sota
    @GeneratedValue(strategy = GenerationType.AUTO)     //Defineix l'estratègia per a treballar amb el llenguatge del SBGB al que ens connectem. El realitza de manera AUTO en funció de les preferències del SGBD
    private Long id;

    @Column
    String description;

    @NotNull
    @Column(name = "start_date")
    private Date startDate;

    //@Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    private Date endDate;

    @ManyToOne
    private Manager manager;

    public Project() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
