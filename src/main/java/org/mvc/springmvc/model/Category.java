package org.mvc.springmvc.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Category")
public class Category {
    @Id

    private long Id;

    @Column(name = "Name")
    private String name;

    public void setId(long id) {
        this.Id = id;
    }
    public long getId() {
        return this.Id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }


}
