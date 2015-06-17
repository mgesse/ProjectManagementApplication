package demo.repository;

import demo.model.Manager;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by poo2 on 17/06/2015.
 */
public interface ManagerRepository extends PagingAndSortingRepository<Manager,Long> {
    //List<Manager> findBySurname(@Param("surname") String surname);
    List<Manager> findByBonusSuccessGreaterThan(@Param("bonusSuccess") Double bonusSuccess);

    /*List<Manager> findByNameAndSurname(@Param("name") String name,
                                       @Param("surname") String surname);

    List<Manager> findByStartDateBetween(@Param("start") Date start,
                                         @Param("end") Date end);*/
}
