package org.mvc.springmvc.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Product")
public class Product {
    @Id

    @Column(name = "Id")
    private long id;

    @Column(name = "Name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "Category", referencedColumnName = "Id")
    private Category category;
    public void setId(Long id) {
        this.id = id;
    }
    public long getId() {
        return id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public Category getCategory() {
        return category;
    }



}
