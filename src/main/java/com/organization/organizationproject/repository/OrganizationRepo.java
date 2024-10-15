package com.organization.organizationproject.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.organization.organizationproject.model.OrganizationModel;



@Repository
public interface  OrganizationRepo extends MongoRepository<OrganizationModel, String>{

}


