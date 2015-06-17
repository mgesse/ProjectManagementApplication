package demo.repository;

import demo.model.Developer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by poo2 on 17/06/2015.
 */
public interface DeveloperRepository extends PagingAndSortingRepository<Developer,Long> {
    List<Developer> findBySurname(@Param("surname") String surname);
    List<Developer> findBySalaryEquals(@Param("salary") Double salary);

    List<Developer> findByNameAndSurname(@Param("name") String name,
                                        @Param("surname") String surname);

    List<Developer> findByStartDateBetween(@Param("start") Date start,
                                          @Param("end") Date end);
}
