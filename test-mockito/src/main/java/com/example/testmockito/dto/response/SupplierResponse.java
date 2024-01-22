package com.example.testmockito.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SupplierResponse {

    private String contactPersonName;
    private String contactPersonEmail;
    private String contactPersonContactNo;
    private String contactItem;

    private String supplierName;
    private String supplierContact;
    private String supplierEmail;
    private String supplierWeb;
    private String supplierDetails;

}
