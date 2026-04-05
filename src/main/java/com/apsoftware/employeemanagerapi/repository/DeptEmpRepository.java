package repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apsoftware.employeemanagerapi.entity.DeptEmp;
import com.apsoftware.employeemanagerapi.entity.DeptEmpId;

@Repository
public interface DeptEmpRepository extends JpaRepository<DeptEmp, DeptEmpId> {

    List<DeptEmp> findByEmployee_EmpNo(Integer empNo);

    List<DeptEmp> findByDepartment_DeptNo(String deptNo);

    // Current department (assuming "active" = toDate in future)
    @Query("SELECT d FROM DeptEmp d WHERE d.employee.empNo = :empNo AND d.toDate = :toDate")
    List<DeptEmp> findCurrentDepartment(Integer empNo, LocalDate toDate);

}
