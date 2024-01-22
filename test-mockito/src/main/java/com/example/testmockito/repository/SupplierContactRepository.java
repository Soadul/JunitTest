package com.example.testmockito.repository;

import com.example.testmockito.model.SupplierContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository

public interface SupplierContactRepository extends JpaRepository<SupplierContact, Long> {


    @Modifying
    @Transactional
    @Query("UPDATE SupplierContact sc SET sc.contactPersonName = :contactPersonName, " +
            "sc.contactPersonEmail = :contactPersonEmail, sc.contactPersonContactNo = :contactPersonContactNo, " +
            "sc.contactItem = :contactItem " +
            "WHERE sc.id = :id")
    void updateSupplierContactFieldsByIds(
            @Param("contactPersonName") String contactPersonName,
            @Param("contactPersonEmail") String contactPersonEmail,
            @Param("contactPersonContactNo") String contactPersonContactNo,
            @Param("contactItem") String contactItem,
            @Param("id") Long id);
boolean existsByContactPersonName(String contactPersonName);
boolean existsBycontactPersonEmail(String contactPersonEmail);
boolean existsBycontactPersonContactNo(String contactPersonContactNo);

void deleteById(Long id);

}
