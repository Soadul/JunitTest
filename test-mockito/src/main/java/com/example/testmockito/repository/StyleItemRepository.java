package com.example.testmockito.repository;


import com.example.testmockito.model.StyleMain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StyleItemRepository extends JpaRepository<StyleMain, Long> {
  @Query("SELECT s.styleNo FROM StyleMain s")
  List<String> getStyleNos();

  Optional<StyleMain> findByStyleNoContainingIgnoreCase(String styleNo);

  Optional<StyleMain> findById(Long id);
  boolean existsByStyleNo(String styleNo);
}
