package com.example.testmockito.service;


import com.example.testmockito.dto.SupplierContactRequestDTO;
import com.example.testmockito.dto.response.Response;
import com.example.testmockito.model.SupplierContact;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public interface ISupplierContactService {

    List<SupplierContact> getAllSupplierContacts();

    Optional<SupplierContact> getSupplierContactById(Long id);

    Response<SupplierContact> updateSupplierContact(Long id, SupplierContactRequestDTO requestDTO);

    @Transactional
    SupplierContact createSupplierContact(SupplierContactRequestDTO requestDTO);

    Response<Void> deleteSupplierContact(Long id);
}
