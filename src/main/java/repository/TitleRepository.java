package repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apsoftware.employeemanagerapi.entity.Title;
import com.apsoftware.employeemanagerapi.entity.TitleId;

@Repository
public interface TitleRepository extends JpaRepository<Title, TitleId> {

    List<Title> findByEmployee_EmpNo(Integer empNo);

    // Get current title
    @Query("SELECT t FROM Title t WHERE t.employee.empNo = :empNo AND t.toDate IS NULL")
    Optional<Title> findCurrentTitle(Integer empNo);

}
