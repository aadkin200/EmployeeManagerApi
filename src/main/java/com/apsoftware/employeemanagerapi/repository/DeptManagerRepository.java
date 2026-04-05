package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apsoftware.employeemanagerapi.entity.DeptManager;
import com.apsoftware.employeemanagerapi.entity.DeptManagerId;

@Repository
public interface DeptManagerRepository extends JpaRepository<DeptManager, DeptManagerId> {

    List<DeptManager> findByEmployee_EmpNo(Integer empNo);

    List<DeptManager> findByDepartment_DeptNo(String deptNo);

}
