package com.alexistdev.lmsfav.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="roles")
@NoArgsConstructor
public class Role extends AuditEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "VARCHAR(255)")
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "status")
    private String status;

    @lombok.Builder
    public Role(String name, String description, String status, Date createdAt, String createdBy, Date updatedAt, String modifiedBy) {
        super(createdAt, updatedAt, createdBy, modifiedBy);
        this.name = name;
        this.description = description;
        this.status = status;
    }
}
