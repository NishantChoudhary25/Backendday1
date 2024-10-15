package com.organization.organizationproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.organizationproject.dto.OrganizationDTO;
import com.organization.organizationproject.model.OrganizationModel;
import com.organization.organizationproject.repository.OrganizationRepo;

@Service
public class OrganizationService {

    // @Autowired
    // private OrganizationRepo organizationRepository;

    // public List<OrganizationModel> getAllOrganizations() {
    //     return organizationRepository.findAll();
    // }

    // public Optional<OrganizationModel>  getOrganizationById(String id) {
    //     return organizationRepository.findById(id);
    // }

    // public OrganizationModel addOrganization(OrganizationModel organization) {
    //     return organizationRepository.save(organization);
    // }

    // public OrganizationModel updateOrganization(String id, OrganizationModel updatedOrganization) {
    //     return organizationRepository.findById(id).map(org -> {
    //         org.setName(updatedOrganization.getName());
    //         org.setEmail(updatedOrganization.getEmail());
    //         org.setAddress(updatedOrganization.getAddress());
    //         org.setContact(updatedOrganization.getContact());
    //         return organizationRepository.save(org);
    //     }).orElseGet(() -> {
    //         updatedOrganization.setId(id);
    //         return organizationRepository.save(updatedOrganization);
    //     });
    // }

    // public void deleteOrganization(String id) {
    //     organizationRepository.deleteById(id);
    // }



     @Autowired
    private OrganizationRepo organizationRepository;

    public List<OrganizationModel> getAllOrganizations() {
        return organizationRepository.findAll();
    }

    public Optional<OrganizationModel> getOrganizationById(String id) {
        return organizationRepository.findById(id);
    }

    public OrganizationModel addOrganization(OrganizationDTO organizationDTO) {
        OrganizationModel organization = new OrganizationModel();
        organization.setName(organizationDTO.getName());
        organization.setEmail(organizationDTO.getEmail());
        organization.setAddress(organizationDTO.getAddress());
        organization.setContact(organizationDTO.getContact());
        return organizationRepository.save(organization);
    }

    public OrganizationModel updateOrganization(String id, OrganizationDTO updatedOrganizationDTO) {
        return organizationRepository.findById(id).map(org -> {
            org.setName(updatedOrganizationDTO.getName());
            org.setEmail(updatedOrganizationDTO.getEmail());
            org.setAddress(updatedOrganizationDTO.getAddress());
            org.setContact(updatedOrganizationDTO.getContact());
            return organizationRepository.save(org);
        }).orElseGet(() -> {
            OrganizationModel newOrganization = new OrganizationModel();
            newOrganization.setId(id);
            newOrganization.setName(updatedOrganizationDTO.getName());
            newOrganization.setEmail(updatedOrganizationDTO.getEmail());
            newOrganization.setAddress(updatedOrganizationDTO.getAddress());
            newOrganization.setContact(updatedOrganizationDTO.getContact());
            return organizationRepository.save(newOrganization);
        });
    }

    public void deleteOrganization(String id) {
        organizationRepository.deleteById(id);
    }

}



