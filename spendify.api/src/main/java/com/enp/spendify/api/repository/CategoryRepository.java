package com.enp.spendify.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enp.spendify.api.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

}
