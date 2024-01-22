package com.example.testmockito.dto;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StyleItemDTO {
    private String itemName;
    private String itemCode;
    private String itemDescription;
    private  String itemUnit;
    private Double consumption;
    private String itemColour;
    private String gmtColour;
    private List<String> gmtSize;
    private String gsm;
    private String wastage;
    private Boolean status;

    // getters and setters
}
