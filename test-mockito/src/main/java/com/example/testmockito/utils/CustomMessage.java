package com.example.testmockito.utils;

public class CustomMessage {
    public static final String SAVE_SUCCESS_MESSAGE = " has been saved successfully!";
    public static final String UPDATE_SUCCESS_MESSAGE = " has been updated successfully!";
    public static final String DELETE_SUCCESS_MESSAGE = " has been deleted successfully!";
    public static final String SAVE_FAILED_MESSAGE = " Failed to Save";
    public static final String UPDATE_FAILED_MESSAGE = " Failed to Update";
    public static final String DELETE_FAILED_MESSAGE = " Failed to Delete";
    public static final String DATA_FOUND = "Data has been found!";
    public static final String DATA_NOT_VALID = "Data is not valid";
    public static final String NO_RECORD_FOUND = "No record found for given value: ";
    public static final String ALREADY_EXIST = " already exist";

    public abstract static class Api {
        public static final String BASE_API = "/settings/api/v1";

        public static final String BUYER = "/buyer";

        public static final String GMT_COLOR = "/gmt-color";
        public static final String TEST = "/test";
        public static final String Create_Unit = "/create";
        // public static final String Create_Unit = "/create";
        public static final String SUPPLIER = "/supplier";
        public static final String STYLE = "/style";
        public static final String SUPPLIER_MAIN = "/supplier-main";
        public static final String SUPPLIER_CONTACT = "/supplier-contact";
        //public static final String Create_Unit = "/create";

        public static final String CURRENCY = "/currency";

        public static final String GMTSIZE = "/gmt-size";
        public static final String ITEMCOLOR = "/item-color";

        public static final String ITEMSIZE = "/item-size";
        public static final String MEASUREMENTUNIT = "/measurement-unit";
        public static final String CREATE_SUPPLIER = "/create-supplier";
        public static final String GET_ALL_SUPPLIERS = "/get-all-suppliers";
        public static final String UPDATE_SUPPLIER_CONTACT = "/update-supplier-contact/{id}";
        public static final String DELETE_SUPPLIER_CONTACT = "/delete-supplier-contact/{id}";
        public static final String CLIENT_GET_BY_ID = "/client-get-by-id/{id}";
        public static final String SUPPLIER_MAIN_ID = "/supplier-main/{id}";
        public static final String UPDATE_SUPPLIER_MAIN = "/update-supplier-main/{id}";
        public static final String DELETE_SUPPLIER_MAIN = "/delete-supplier-main/{id}";
        public static final String SEARCH_SUPPLIER_MAIN = "/search-supplier-main";
        public static final String CREATE_STYLE_ITEM = "/create-style-item";
        public static final String UPDATE_STYLE_ITEM = "/update-style-item/{id}";
        public static final String DELETE_STYLE_ITEM = "/delete-style-item/{id}";
        public static final String GET_ALL_STYLE_ITEM = "/get-all-style-item";
        public static final String GET_ALL_STYLE_NO = "/get-all-style-no";

    }
}
