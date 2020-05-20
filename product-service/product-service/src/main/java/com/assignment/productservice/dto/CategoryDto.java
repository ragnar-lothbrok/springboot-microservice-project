package com.assignment.productservice.dto;

public class CategoryDto {

    private Long id;

    private String category;

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


    @Override
    public String toString() {
        return "CategoryDto{" +
                "id=" + id +
                ", category='" + category + '\'' +
                '}';
    }
}
