package com.prueba.companies_crud.controllers;

import com.prueba.companies_crud.entities.Company;
import com.prueba.companies_crud.services.CompanyService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path="company")
@Slf4j
public class CompanyController {

    private final CompanyService companyService;
    @GetMapping(path="{name}")
    public ResponseEntity<Company> get(@PathVariable String name){
        log.info("GET: company{}",name);
        return ResponseEntity.ok(this.companyService.readByName(name));
    }
}
