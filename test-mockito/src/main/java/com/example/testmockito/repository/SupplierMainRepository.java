package com.example.testmockito.repository;


import com.example.testmockito.model.SupplierMain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface SupplierMainRepository extends JpaRepository<SupplierMain, Long> {
  // SupplierMain findBySupplierNameContainingIgnoreCase(String supplierName);
  @Query(
      value =
          "SELECT * FROM scm_settings_supllier_main s\n"
              + "WHERE LOWER(s.supplier_name) LIKE LOWER(CONCAT('%', :keyword, '%')) "
              + "   OR LOWER(s.supplier_email) LIKE LOWER(CONCAT('%', :keyword, '%')) "
              + "   OR LOWER(s.supplier_email) LIKE LOWER(CONCAT('%', :keyword, '%')) ",
      nativeQuery = true)
  List<SupplierMain> searchBySupplierNameOrEmailOrWeb(String keyword);



    @Modifying
    @Transactional
    @Query("UPDATE SupplierMain s SET s.supplierContact = :supplierContact, " +
            "s.supplierEmail = :supplierEmail, s.supplierWeb = :supplierWeb, s.supplierDetails = :supplierDetails " +
            "WHERE s.id = :id")
    void updateSupplierFieldsById(
            @Param("supplierContact") String supplierContact,
            @Param("supplierEmail") String supplierEmail,
            @Param("supplierWeb") String supplierWeb,
            @Param("supplierDetails") String supplierDetails,
            @Param("id") Long id);

    boolean existsBySupplierName(String supplierName);
    boolean existsBySupplierEmail(String supplierEmail);
    boolean existsBySupplierContact(String supplierContact);

 }
