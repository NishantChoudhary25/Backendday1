package com.organization.organizationproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.organization.organizationproject.dto.OrganizationDTO;
import com.organization.organizationproject.model.OrganizationModel;
import com.organization.organizationproject.service.OrganizationService;

@RestController
@RequestMapping("/api/organization")
public class OrganizationController {

    // @Autowired
    // private OrganizationService organizationService;


    // @GetMapping("/list")
    // public List<OrganizationModel> getAllOrganizations() {
    //     return organizationService.getAllOrganizations();
    // }


    // @GetMapping("/{id}")
    // public ResponseEntity<OrganizationModel> getOrganizationById(@PathVariable String id) {
    //     Optional<OrganizationModel> organization = organizationService.getOrganizationById(id);
    //     if (organization.isPresent()) {
    //         return ResponseEntity.ok(organization.get());
    //     } else {
    //         return ResponseEntity.notFound().build();
    //     }
    // }


    // @PostMapping("/{create}")
    // public OrganizationModel addOrganization(@RequestBody OrganizationModel organization) {
    //     return organizationService.addOrganization(organization);
    // }


    // @PutMapping("/{id}")
    // public ResponseEntity<OrganizationModel> updateOrganization(@PathVariable String id, @RequestBody OrganizationModel updatedOrganization) {
    //     OrganizationModel organization = organizationService.updateOrganization(id, updatedOrganization);
    //     return ResponseEntity.ok(organization);
    // }


    // @DeleteMapping("/{id}")
    // public ResponseEntity<Void> deleteOrganization(@PathVariable String id) {
    //     organizationService.deleteOrganization(id);
    //     return ResponseEntity.noContent().build();
    // }


       @Autowired
    private OrganizationService organizationService;

    @GetMapping("/list")
    public List<OrganizationModel> getAllOrganizations() {
        return organizationService.getAllOrganizations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrganizationModel> getOrganizationById(@PathVariable String id) {
        Optional<OrganizationModel> organization = organizationService.getOrganizationById(id);
        if (organization.isPresent()) {
            return ResponseEntity.ok(organization.get());
        } 
        else{
                return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public OrganizationModel addOrganization(@RequestBody OrganizationDTO organizationDTO) {
        return organizationService.addOrganization(organizationDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrganizationModel> updateOrganization(@PathVariable String id, @RequestBody OrganizationDTO updatedOrganizationDTO) {
        OrganizationModel organization = organizationService.updateOrganization(id, updatedOrganizationDTO);
        return ResponseEntity.ok(organization);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrganization(@PathVariable String id) {
        organizationService.deleteOrganization(id);
        return ResponseEntity.noContent().build();
    }

}
