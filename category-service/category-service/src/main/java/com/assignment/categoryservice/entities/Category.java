package com.assignment.categoryservice.entities;

import com.assignment.categoryservice.dto.CategoryDto;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "category")
    private String category;

    @Column(name = "created_at")
    private Long createdAt;

    @Column(name = "modified_at")
    private Long modifiedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Long modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public static Category build(CategoryDto categoryDto) {
        Category category = new Category();
        category.setCreatedAt(Instant.now().toEpochMilli());
        category.setCategory(categoryDto.getCategory());
        category.setModifiedAt(Instant.now().toEpochMilli());
        return category;
    }
}
