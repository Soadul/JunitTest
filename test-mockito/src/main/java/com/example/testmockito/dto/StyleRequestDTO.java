package com.example.testmockito.dto;

import lombok.Data;

import java.util.List;

@Data
public class StyleRequestDTO {
    //private StyleMain styleMain;
    private String  styleNo;
    private List<StyleItemDTO> styleItem;
}
