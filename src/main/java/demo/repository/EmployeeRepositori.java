package demo.repository;

import demo.model.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by poo2 on 16/06/2015.
 */

public interface EmployeeRepositori extends PagingAndSortingRepository<Employee, Long> {
    List<Employee> findBySurname(@Param("surname") String surname);
    List<Employee> findBySalaryEquals(@Param("salary") Double salary);

    List<Employee> findByNameAndSurname(@Param("name") String name,
                                        @Param("surname") String surname);

    List<Employee> findByStartDateBetween(@Param("start") Date start,
                                          @Param("end") Date end);

}
