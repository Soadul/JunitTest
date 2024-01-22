package com.example.testmockito.dto;

import lombok.*;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SupplierMainRequestDTO {

    private String supplierName;
    private String supplierContact;
    private String supplierEmail;
    private String supplierWeb;
    private String supplierDetails;

    public Date getCreatedAt() {
        return new Date(System.currentTimeMillis());
    }


    public Date getUpdatedAt() {
          return new Date(System.currentTimeMillis());
    }
}
