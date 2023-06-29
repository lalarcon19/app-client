package com.credibanco.loginback.Service;

import com.credibanco.loginback.Dto.Request.RequestUserDto;
import com.credibanco.loginback.Dto.Response.ResponseUserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServiceUser {
    List<ResponseUserDto> getAllUsers ();
    ResponseUserDto getUserById (long id);
    ResponseUserDto createUser (RequestUserDto requestUserDto);
    ResponseUserDto updateUser (long id, RequestUserDto requestUserDto);
    String deleteUser (long id);
}
