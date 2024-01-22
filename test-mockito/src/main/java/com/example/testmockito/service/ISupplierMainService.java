package com.example.testmockito.service;


import com.example.testmockito.dto.SupplierMainRequestDTO;
import com.example.testmockito.dto.SupplierRequestDTO;
import com.example.testmockito.dto.response.Response;
import com.example.testmockito.model.SupplierMain;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public interface ISupplierMainService {

    Response<List<SupplierMain>> getAllSuppliers();
    List<SupplierMain> getAllSuppliersEdited();

    Response<Optional<SupplierMain>> getSupplierById(Long id);

    public SupplierMain createSupplier(SupplierRequestDTO requestDTO);

    Response<SupplierMain> updateSupplier(Long id, SupplierMainRequestDTO requestDTO);

    Response<Void> deleteSupplier(Long id);

    Response<List<SupplierMain>> searchSupplierMain(String supplierName);



    Response<SupplierMain> getById(Long id);


}
