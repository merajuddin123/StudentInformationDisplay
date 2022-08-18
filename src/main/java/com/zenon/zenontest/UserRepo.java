package com.zenon.zenontest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends JpaRepository<Employee,Integer> {
    @Query("select e from Employee e where e.email= :email")
    public Employee getEmployeeEmail(@Param("email") String email);
    @Query("select e from Employee e ")
    public Page<Employee> findEmployeedeatils(Pageable pageable);
    @Query("select e from Employee e where e.empId= :empId")
    public Employee getEmployeeById(@Param("empId") Integer empId);
}
