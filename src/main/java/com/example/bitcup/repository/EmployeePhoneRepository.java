package com.example.bitcup.repository;

import com.example.bitcup.model.EmployeePhone;
import com.example.bitcup.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeePhoneRepository extends JpaRepository<EmployeePhone, Long> {

    @Query(value = """
    SELECT ep.* 
    FROM employee_phone as ep
    LEFT JOIN employee e ON e.ID = ep.employee_id
    LEFT JOIN department d ON d.ID = e.department_id
    LEFT JOIN job_position jp ON jp.ID = e.job_position_id
    LEFT JOIN phone p on p.ID = ep.phone_id
    LEFT JOIN workplace wp on wp.ID = p.workplace_id
    WHERE (e.FIRST_NAME ilike :searchValue OR
    e.MIDDLE_NAME ilike :searchValue OR 
    e.LAST_NAME ilike :searchValue OR
    e.MAIL ilike :searchValue OR
    d.NAME ilike :searchValue OR
    jp.NAME ilike :searchValue OR
    p.VALUE ilike :searchValue OR
    wp.NAME ilike :searchValue) and p.type in :types
    """, nativeQuery = true)
    List<EmployeePhone> find(@Param("searchValue") String searchValue,
                             @Param("types") List<Phone.Type> types);

    List<EmployeePhone> findByPhoneTypeIn(List<Phone.Type> types);
}
