package com.example.testmockito.service;



import com.example.testmockito.dto.StyleItemDTOUpdate;
import com.example.testmockito.dto.StyleRequestDTO;
import com.example.testmockito.dto.response.Response;
import com.example.testmockito.dto.response.StyleMainResponse;
import com.example.testmockito.model.StyleItem;
import com.example.testmockito.model.StyleMain;

import java.util.List;

public interface IStyleItemService {

   Response<Void> deleteStyleItem(Long id);

  StyleMain createStyleItem(StyleRequestDTO styleItemRequestDTO);
  Response<StyleItem> updateStyleItem(StyleItemDTOUpdate styleItemDTO, Long id);

  List<StyleMain> ListgetAllStyleItem(StyleRequestDTO requestDTO);

  List<StyleMain> getAllStyleItem();

  List<String> getAllStyleNo();

  Response<StyleMain> getStyleByStyleNo(String styleNo);

  Response<StyleMain> getById(Long id);

  Response<StyleMainResponse> getStyleMatchedWithOrder(String styleNo, Long gmtSize, Long gmtColor);
}
