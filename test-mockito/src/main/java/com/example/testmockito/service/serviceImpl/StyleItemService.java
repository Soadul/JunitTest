package com.example.testmockito.service.serviceImpl;


import com.example.testmockito.dto.StyleItemDTO;
import com.example.testmockito.dto.StyleItemDTOUpdate;
import com.example.testmockito.dto.StyleRequestDTO;
import com.example.testmockito.dto.response.Response;
import com.example.testmockito.dto.response.StyleMainResponse;
import com.example.testmockito.model.StyleItem;
import com.example.testmockito.model.StyleMain;
import com.example.testmockito.model.UserDTO;
import com.example.testmockito.repository.StyleItemDupRepository;
import com.example.testmockito.repository.StyleItemRepository;
import com.example.testmockito.service.IStyleItemService;
import com.example.testmockito.utils.StatusCode;
import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class StyleItemService implements IStyleItemService {

    private final StyleItemRepository styleItemRepository;
    private final ModelMapper modelMapper;
    private final StyleItemDupRepository styleItemDupRepository;




    @Override
    public Response<StyleItem> updateStyleItem(StyleItemDTOUpdate styleItemDTO, Long id) {
        Optional<StyleItem> optionalStyleItem = styleItemDupRepository.findById(id);

        StyleItem updatedStyle = null;
        if (optionalStyleItem.isPresent()) {
            StyleItem existingStyle = optionalStyleItem.get();
            existingStyle.setItemColour(styleItemDTO.getItemColour());
            existingStyle.setItemCode(styleItemDTO.getItemCode());
            existingStyle.setItemName(styleItemDTO.getItemName());
            existingStyle.setItemUnit(styleItemDTO.getItemUnit());
            existingStyle.setItemDescription(styleItemDTO.getItemDescription());
            existingStyle.setGmtSize(styleItemDTO.getGmtSize());

            try {
                updatedStyle = styleItemDupRepository.save(existingStyle);
                return new Response<>(Integer.parseInt(StatusCode.OK), true, "Style Item Updated Successfully", updatedStyle);
            } catch (Exception e) {
                System.out.println("eRROR");
            }

        } else {
            System.out.println("eRROR");
        }
        return new Response<>(Integer.parseInt(StatusCode.OK), true, "Style Item Updated Successfully", updatedStyle);

    }







    @Override
    public Response<Void> deleteStyleItem(Long id) {
        try {
            styleItemDupRepository.deleteById(id);
            return new Response<>(Integer.parseInt(StatusCode.OK), true, "Style Item Deleted Successfully", null);
        }
        catch (Exception e) {
            System.out.println("Error while deleting");
        }
        return new Response<>(Integer.parseInt(StatusCode.OK), true, "Style Item Deleted Successfully", null);

    }

    @Override
    public StyleMain createStyleItem(StyleRequestDTO styleRequestDTO) {

        StyleMain styleMain = new StyleMain();
        styleMain.setStyleNo(styleRequestDTO.getStyleNo());
        List<StyleItem> styleItemList = new ArrayList<>();
        for(StyleItemDTO styleItem : styleRequestDTO.getStyleItem()){
            for(String gmtSize : styleItem.getGmtSize()){
                StyleItem item = modelMapper.map(styleItem, StyleItem.class);
                item.setGmtSize(gmtSize);
                styleItemList.add(item);
            }
        }
        styleMain.setStyleItem(styleItemList);
        styleMain.setStatus(false);
        try{
            styleItemRepository.save(styleMain);
        }catch(Exception e){
         //   throw new CustomDataIntegrityViolationException("Can not save style for : " + e);
        }
        return styleMain;
    }

    @Override
    public List<StyleMain> ListgetAllStyleItem(StyleRequestDTO requestDTO) {
        return styleItemRepository.findAll();
    }

    @Override
    public List<StyleMain> getAllStyleItem() {
        return styleItemRepository.findAll();
    }

    @Override
    public List<String> getAllStyleNo() {
        return styleItemRepository.getStyleNos();
    }

    @Override
    public Response<StyleMain> getStyleByStyleNo(String styleNo) {
        Optional<StyleMain> styleMainOptional = styleItemRepository.findByStyleNoContainingIgnoreCase(styleNo.trim());
        if (styleMainOptional.isEmpty()) {
            return new Response<>(Integer.parseInt(StatusCode.NO_CONTENT), false, "No Style found", null);
        }
        return new Response<>(Integer.parseInt(StatusCode.OK), true, "Style found", styleMainOptional.get());
    }

    @Override
    public Response<StyleMain> getById(Long id) {
        Optional<StyleMain> styleMainOptional = styleItemRepository.findById(id);
        if (styleMainOptional.isEmpty()) {
            return new Response<>(Integer.parseInt(StatusCode.NO_CONTENT), false, "No Style found", null);
        }
        return new Response<>(Integer.parseInt(StatusCode.OK), true, "Style found", styleMainOptional.get());
    }

    @Override
    public Response<StyleMainResponse> getStyleMatchedWithOrder(String styleNo, Long gmtSize, Long gmtColor) {
        return null;
    }


    private StyleMain convertToEntity(StyleRequestDTO requestDTO) {
        StyleMain styleMain = this.modelMapper.map(requestDTO, StyleMain.class);
        //UserDTO userDTO = getUserInfoFromRequestHeader();

        styleMain.setUpdatedAt(new Date());
      //  styleMain.setCreatedBy(userDTO.getId());

        return styleMain;
    }

    private StyleItem convertToEntity(StyleItemDTO styleItemDTO, StyleRequestDTO styleRequestDTO) {
        StyleItem styleItem = this.modelMapper.map(styleItemDTO, StyleItem.class);


        //UserDTO userDTO = getUserInfoFromRequestHeader();

        styleItem.setUpdatedAt(new Date());
       // styleItem.setUpdatedBy(userDTO.getId());
      //  styleItem.setCreatedBy(userDTO.getId());

        // Set other fields if needed

        return styleItem;
    }
}
