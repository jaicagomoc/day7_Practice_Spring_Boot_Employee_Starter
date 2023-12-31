package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.model.Company;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    CompanyRepository companyRepository;

    @GetMapping
    public List<Company> listAll() {
        return companyRepository.getCompanies();
    }
    @GetMapping("/{companyId}")
    public Company findById(@PathVariable Long companyId) {
        return companyRepository.findById(companyId);
    }
    @PostMapping
    public ResponseEntity<String> saveCompany(@RequestBody Company company) {
        companyRepository.saveCompany(company);
        return new ResponseEntity<>(company.getCompanyName() + " was added to the list of Employee.", HttpStatus.CREATED);
    }

    @PutMapping("/{companyId}")
    public ResponseEntity<String> updateCompany(@PathVariable Long companyId, @RequestBody Company updatedCompany) {
        Company existingCompany = companyRepository.findById(companyId);
        if (existingCompany == null) {return ResponseEntity.notFound().build();}
        existingCompany.setCompanyName(updatedCompany.getCompanyName());
        return new ResponseEntity<>(existingCompany.getCompanyName() + " was updated.", HttpStatus.OK);
    }

}
