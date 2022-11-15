package com.example.bitcup.repository;

import com.example.bitcup.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
    List<Phone> findByTypeIn(List<Phone.Type> types);
}
