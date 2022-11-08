package com.ideas2it.training.dao;
import java.lang.String;

import com.ideas2it.training.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeDao extends JpaRepository<Employee,String> {
//    @Query("SELECT e From Employee e Where e.employeeId = CONCAT('%',:employeeId, '%')")
//    public Employee findById(@Param("employeeId") String employeeId);
}