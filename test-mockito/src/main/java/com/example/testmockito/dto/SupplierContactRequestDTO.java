package com.example.testmockito.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SupplierContactRequestDTO {

    private String contactPersonName;
    private String contactPersonEmail;
    private String contactPersonContactNo;
    private String contactItem;

}
