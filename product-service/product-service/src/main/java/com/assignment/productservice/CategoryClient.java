package com.assignment.productservice;

import com.assignment.productservice.dto.CategoryDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryClient.class);

    @Autowired
    private RestTemplate restTemplate;

    private List<CategoryDto> getCategories() {
        ParameterizedTypeReference<List<CategoryDto>> myBean =
                new ParameterizedTypeReference<List<CategoryDto>>() {
                };
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        try {
            categoryDtoList = restTemplate.exchange("http://category-service/category/v1", HttpMethod.GET, null, myBean).getBody();
        } catch (Exception exception) {
            LOGGER.error("Exception occurred while fetching categories = {} ", exception);
        }
        return categoryDtoList;
    }

    public boolean categoryAvailable(String category) {
        List<CategoryDto> categoryDtoList = getCategories();
        for (CategoryDto categoryDto : categoryDtoList) {
            if (categoryDto.getCategory().equalsIgnoreCase(category)) {
                LOGGER.info("Category matched = {}", category);
                return true;
            }
        }
        return false;
    }

}
