package com.example.bitcup.service;

import com.example.bitcup.model.EmployeePhone;
import com.example.bitcup.model.Phone;
import com.example.bitcup.repository.EmployeePhoneRepository;
import com.example.bitcup.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PhoneService {
    @Autowired
    EmployeePhoneRepository employeePhoneRepository;

    @Autowired
    PhoneRepository phoneRepository;

    public List<EmployeePhone> search(User user, String query) {
        List<Phone.Type> types = getAvailableTypes(user);
        if(query == null || query.isEmpty())
            return employeePhoneRepository.findByPhoneTypeIn(types);
        return employeePhoneRepository.find("%"+ query + "%", types);
    }

    private List<Phone.Type> getAvailableTypes(User user){
        if(user == null) return List.of(Phone.Type.EXTERNAL);
        return List.of(Phone.Type.EXTERNAL, Phone.Type.INTERNAL);
    }

    public List<EmployeePhone> findAll() {
        return employeePhoneRepository.findByPhoneTypeIn(List.of(Phone.Type.EXTERNAL, Phone.Type.INTERNAL));
    }

    public void deletePhone(Long id){
        employeePhoneRepository.delete(employeePhoneRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new));
    }

    public EmployeePhone findById(Long id) {
        return employeePhoneRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public void save(EmployeePhone employeePhone) {
         employeePhoneRepository.save(employeePhone);
    }


}
