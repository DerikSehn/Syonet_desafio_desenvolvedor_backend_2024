package com.syonet.domain.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "newsletters")
public class Newsletter extends PanacheEntity {

    @Column(nullable = false)
    @NotNull
    @Size(min = 1)
    public String title;

    @Column(nullable = false)
    @NotNull
    @Size(min = 1)
    public String description;

    @Column
    @Pattern(regexp = "^(https?|ftp)://[^\s/$.?#].[^\s]*$", message = "Invalid URL format")
    public String link;

    @Column(nullable = false)
    public boolean sent;
}