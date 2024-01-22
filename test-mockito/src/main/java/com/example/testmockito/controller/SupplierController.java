package com.example.testmockito.controller;


import com.example.testmockito.dto.SupplierContactRequestDTO;
import com.example.testmockito.dto.SupplierMainRequestDTO;
import com.example.testmockito.dto.SupplierRequestDTO;
import com.example.testmockito.dto.response.Response;
import com.example.testmockito.model.SupplierContact;
import com.example.testmockito.model.SupplierMain;
import com.example.testmockito.service.ISupplierContactService;
import com.example.testmockito.service.ISupplierMainService;
import com.example.testmockito.utils.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(Api.BASE_API + Api.SUPPLIER)
public class SupplierController {


    private final ISupplierMainService iSupplierMainService;
    private final ISupplierContactService iSupplierContactService;


    @PostMapping(Api.CREATE_SUPPLIER)
    public Response<SupplierMain> createSupplier(@RequestBody SupplierRequestDTO request) {
        Response<SupplierMain> response = new Response<>();
        SupplierMain createdSupplier = iSupplierMainService.createSupplier(request);
        response.setData(createdSupplier);
        return response;

    }
    //==================================

    @GetMapping(Api.GET_ALL_SUPPLIERS)
    public Response<List<SupplierMain>> getAllSuppliers() {
        Response<List<SupplierMain>> suppliers = iSupplierMainService.getAllSuppliers();
        return suppliers;
    }


    @PutMapping(Api.UPDATE_SUPPLIER_CONTACT)
    public Response<SupplierContact> updateSupplier(@PathVariable Long id, @RequestBody SupplierContactRequestDTO requestDTO) {
        Response<SupplierContact> updatedSupplier = iSupplierContactService.updateSupplierContact(id, requestDTO);
        return updatedSupplier;

    }

    //===============Delete Supplier Contact========
    @DeleteMapping(Api.DELETE_SUPPLIER_CONTACT)
    public Response<Void> deleteSupplier(@PathVariable Long id) {
        Response<Void> response = iSupplierContactService.deleteSupplierContact(id);
        return response;
    }


    //Supplier Main Get API
    @GetMapping(Api.SUPPLIER_MAIN_ID)
    public Response<Optional<SupplierMain>> getSupplierById(@PathVariable Long id) {
        Response<Optional<SupplierMain>> supplier = iSupplierMainService.getSupplierById(id);
        return supplier;
    }

    @PutMapping(Api.UPDATE_SUPPLIER_MAIN)
    public Response<SupplierMain> updateSupplier(
            @PathVariable Long id, @RequestBody SupplierMainRequestDTO requestDTO) {
        Response<SupplierMain> updatedSupplier = iSupplierMainService.updateSupplier(id, requestDTO);
        return updatedSupplier;
    }

    @GetMapping(Api.CLIENT_GET_BY_ID)
    public Response<SupplierMain> getById(@PathVariable Long id) {
        return iSupplierMainService.getById(id);
    }

    @DeleteMapping(Api.DELETE_SUPPLIER_MAIN)
    public Response<Void> deleteSupplierMain(@PathVariable Long id) {
        Response<Void> response = iSupplierMainService.deleteSupplier(id);
        return response;


    }

    // ===========Searching Option========

    @GetMapping(Api.SEARCH_SUPPLIER_MAIN)
    public Response<List<SupplierMain>> searchSupplierMain(@RequestParam String supplierName) {
        Response<List<SupplierMain>> searchResults = iSupplierMainService.searchSupplierMain(supplierName);
        return searchResults;
    }


}
