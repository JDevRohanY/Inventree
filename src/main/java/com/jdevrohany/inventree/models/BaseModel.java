package com.jdevrohany.inventree.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id
    private String id;
    private Date created_at;
    private Date updated_at;
    private boolean isDeleted;
}
