package com.example.testmockito.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SupplierRequestDTO {

    //private SupplierMain supplierMain;
    private String supplierName;
    private String supplierContact;
    private String supplierEmail;
    private String supplierWeb;
    private String supplierDetails;
    private List<SupplierContactRequestDTO> supplierContacts;

}
