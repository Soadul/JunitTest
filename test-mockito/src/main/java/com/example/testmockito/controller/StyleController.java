package com.example.testmockito.controller;

import com.example.testmockito.dto.StyleItemDTOUpdate;
import com.example.testmockito.dto.StyleRequestDTO;
import com.example.testmockito.dto.response.Response;
import com.example.testmockito.dto.response.StyleMainResponse;
import com.example.testmockito.model.StyleItem;
import com.example.testmockito.model.StyleMain;
import com.example.testmockito.repository.StyleItemRepository;
import com.example.testmockito.service.IStyleItemService;
import com.example.testmockito.utils.CustomMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(CustomMessage.Api.BASE_API + CustomMessage.Api.STYLE)
public class StyleController {

    private final IStyleItemService iStyleItemService;

    private final StyleItemRepository styleItemRepository;

    @GetMapping("/client-get-by-style-no/{styleNo}")
    public Response<StyleMain> clientGetByStyleNo(@PathVariable String styleNo) {
        return iStyleItemService.getStyleByStyleNo(styleNo);
    }

    @GetMapping("/client-get-by-id/{id}")
    public Response<StyleMain> clientGetById(@PathVariable Long id) {
        return iStyleItemService.getById(id);
    }

    @PostMapping(CustomMessage.Api.CREATE_STYLE_ITEM)
    public Response<StyleMain> createSupplier(@RequestBody StyleRequestDTO requestDTO) {
        Response<StyleMain> response = new Response<>();
        StyleMain createdStyle = iStyleItemService.createStyleItem(requestDTO);

        return response;
    }


    @PutMapping(CustomMessage.Api.UPDATE_STYLE_ITEM)
    public Response<StyleItem> updateSupplier(@PathVariable Long id, @RequestBody StyleItemDTOUpdate requestDTO) {
        Response<StyleItem> updateStyle = iStyleItemService.updateStyleItem(requestDTO, id);
        return updateStyle;
    }

    @DeleteMapping(CustomMessage.Api.DELETE_STYLE_ITEM)
    public Response<Void> deleteSupplier(@PathVariable Long id) {
        Response<Void> response = iStyleItemService.deleteStyleItem(id);
        return response;
    }


    //================GET ALL STYLE  ITEM===========
    @GetMapping(CustomMessage.Api.GET_ALL_STYLE_ITEM)
    public Response<List<StyleMain>> getAllStyleItem() {
        Response<List<StyleMain>> response = new Response<>();
        List<StyleMain> styleItem = iStyleItemService.getAllStyleItem();
        response.setData(styleItem);
        return response;
    }

    //===========GET ALL STYLE NO================
    @GetMapping(CustomMessage.Api.GET_ALL_STYLE_NO)
    public List<String> getAllStyleNo() {
        List<String> styleItem = iStyleItemService.getAllStyleNo();
        return styleItem;
    }

    @GetMapping("/client-get-matched-style-items-with-order/{styleNo}/{gmtColor}/{gmtSize}")
    public Response<StyleMainResponse> getMatchedStyleItems(@PathVariable("styleNo") String styleNo,
                                                            @PathVariable("gmtColor") Long gmtColor, @PathVariable("gmtSize") Long gmtSize) {
        return iStyleItemService.getStyleMatchedWithOrder(styleNo, gmtSize, gmtColor);
    }


}
