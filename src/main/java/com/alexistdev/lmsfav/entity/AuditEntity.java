package com.alexistdev.lmsfav.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

import static jakarta.persistence.TemporalType.TIMESTAMP;

@Getter
@Setter
@MappedSuperclass
@AllArgsConstructor
public class AuditEntity {
    @CreatedDate
    @Temporal(TIMESTAMP)
    @Column(name="created_at")
    private Date createdAt;

    @CreatedDate
    @Temporal(TIMESTAMP)
    @Column(name="updated_at")
    private Date updatedAt;

    @Column(name="created_by")
    private String createdBy;

    @Column(name="modified_by")
    private String modifiedBy;

    public AuditEntity() {
    }

//    public AuditEntity(Date createdAt, Date updatedAt, String createdBy, String modifiedBy) {
//        this.createdAt = createdAt;
//        this.updatedAt = updatedAt;
//        this.createdBy = createdBy;
//        this.modifiedBy = modifiedBy;
//    }

//    public static class Builder {
//        protected Date createdAt;
//        protected Date updatedAt;
//        protected String createdBy;
//        protected String modifiedBy;
//
//        Builder() {}
//
//        public AuditEntity build() {
//            return new AuditEntity(createdAt,updatedAt,createdBy,modifiedBy);
//        }
//    }
}
