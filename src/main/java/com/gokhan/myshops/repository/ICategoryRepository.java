package com.gokhan.myshops.repository;

import com.gokhan.myshops.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository  extends JpaRepository<Category, Long> {

    Category findByName(String name);

    boolean existByName(String name);
}
