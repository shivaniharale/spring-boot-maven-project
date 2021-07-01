package com.example.employeepayroll.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.Instant;


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<U> {

    @CreatedBy
    @Column(name = "created_by")
    @JsonIgnore
    private U createdBy;

    @CreatedDate
    @Column(name = "created_date")
    @JsonIgnore
    private Instant createdDate=Instant.now();

    @LastModifiedBy
    @Column(name = "last_updated_by")
    @JsonIgnore
    private U lastUpdatedBy;


    @LastModifiedDate
    @Column(name = "last_updated_date")
    @JsonIgnore
    private Instant lastUpdatedDate=Instant.now();


    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public U getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(U createdBy) {
        this.createdBy = createdBy;
    }

    public U getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(U lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Instant getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Instant lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }
}
