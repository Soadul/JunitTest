/*
package com.example.testmockito.utils;


import com.example.testmockito.model.UserDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class RequestHeaderUtils {
    
    private static final String USER_HEADER_NAME = "loggedInUser";
    
    public static UserDTO getUserInfoFromRequestHeader() {
        Gson gson = new Gson();
        
        String header = getHeader(USER_HEADER_NAME);
        if (header != null) {
            return gson.fromJson(header, UserDTO.class);
        }
        return new UserDTO();
    }
    
    public static String getAuthorizationHeaderFromRequestHeader() {
        return getHeader(HttpHeaders.AUTHORIZATION);
    }
    
    private static String getHeader(String headerName) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            HttpServletRequest servletRequest = attributes.getRequest();
            return servletRequest.getHeader(headerName);
        }
        return null;
    }
}
*/
