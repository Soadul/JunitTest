package com.example.testmockito.repository;


import com.example.testmockito.model.StyleItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StyleItemDupRepository extends JpaRepository<StyleItem,Long> {
    boolean existsByItemCode(String itemCode);
}
