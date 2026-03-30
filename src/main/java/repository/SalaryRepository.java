package repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apsoftware.employeemanagerapi.entity.Salary;
import com.apsoftware.employeemanagerapi.entity.SalaryId;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, SalaryId> {

    List<Salary> findByEmployee_EmpNo(Integer empNo);

    @Query("SELECT s FROM Salary s WHERE s.employee.empNo = :empNo ORDER BY s.id.fromDate DESC")
    List<Salary> findSalaryHistory(Integer empNo);

    @Query("SELECT s FROM Salary s WHERE s.employee.empNo = :empNo AND s.toDate = :toDate")
    Optional<Salary> findCurrentSalary(Integer empNo, LocalDate toDate);

}
