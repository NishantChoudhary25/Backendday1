package com.organization.organizationproject.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
//import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
// @NoArgsConstructor

@Document(collection = "organizations")
public class OrganizationModel {

    @Id

    private String id;

    private String name;
    
    private String email;

    private String address;

    private String contact;

    
    @CreatedDate
    private LocalDateTime createdAt;


    @LastModifiedDate
    private LocalDateTime updatedAt;

    public OrganizationModel() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now(); 
    }
    
}





