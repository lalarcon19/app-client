package com.credibanco.loginback.Utils;


import com.credibanco.loginback.Dto.Response.ResponseUserDto;
import com.credibanco.loginback.Entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class ConvertDto {

    @Autowired
    ObjectMapper objectMapper;
    public ResponseUserDto convertUserToResponseDTO (User user){
        return objectMapper.convertValue(user, ResponseUserDto.class);
    }
}
