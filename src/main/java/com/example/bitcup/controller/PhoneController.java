package com.example.bitcup.controller;

import com.example.bitcup.model.EmployeePhone;
import com.example.bitcup.repository.EmployeePhoneRepository;
import com.example.bitcup.repository.PhoneRepository;
import com.example.bitcup.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PhoneController {

    @Autowired
    PhoneService phoneService;

    @Autowired
    EmployeePhoneRepository employeePhoneRepository;

    @Autowired
    PhoneRepository phoneRepository;

    @GetMapping("/")
    public String searchPhones(@AuthenticationPrincipal User user, String query, Model model){
        List<EmployeePhone> phones = phoneService.search(user, query);
        model.addAttribute("employee_phones", phones);
        return "phonebook";
    }

    @GetMapping("/phone-list")
    @PreAuthorize("isAuthenticated() && hasAuthority('ADMIN')")
    public String getPhones(Model model){
        List<EmployeePhone> phones = phoneService.findAll();
        model.addAttribute("employee_phones", phones);
        return "phone-list";
    }

    @GetMapping("/add-phone")
    public String showAddPhonePage(Model model) {
        model.addAttribute("employee_phone", new EmployeePhone());
        return "editor";
    }

    @GetMapping("/delete-phone")
    public String deletePhone(@RequestParam long id) {
        phoneService.deletePhone(id);
        return "redirect:/phone-list";
    }

    @GetMapping("/update-phone")
    public String showUpdatePhonePage(@RequestParam long id, Model model) {
        EmployeePhone phone = phoneService.findById(id);
        model.addAttribute("employee_phone", phone);
        return "editor";
    }

    @PostMapping("/save-phone")
    public String updatePhone(EmployeePhone employeePhone) {
        phoneService.save(employeePhone);
        return "redirect:/phone-list";
    }
}
