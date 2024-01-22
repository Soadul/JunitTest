package com.example.testmockito.dto.response;

import com.example.testmockito.model.StyleItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StyleMainResponse {
    Long id;
    private boolean status;
    private String styleNo;
    private List<StyleItem> styleItem;
}
