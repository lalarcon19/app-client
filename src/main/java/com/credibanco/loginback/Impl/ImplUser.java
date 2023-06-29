package com.credibanco.loginback.Impl;

import com.credibanco.loginback.Dto.Request.RequestUserDto;
import com.credibanco.loginback.Dto.Response.ResponseUserDto;
import com.credibanco.loginback.Entity.User;
import com.credibanco.loginback.Repository.RepositoryUser;
import com.credibanco.loginback.Service.IServiceUser;
import com.credibanco.loginback.Utils.ConvertDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ImplUser implements IServiceUser {
    @Autowired
    RepositoryUser repositoryUser;

    @Autowired
    ObjectMapper objectMapper;

    
    @Override
    public List<ResponseUserDto> getAllUsers() {
        List<User> userList = repositoryUser.findAll();
        return userList.stream()
                .map(user -> objectMapper.convertValue(user,ResponseUserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ResponseUserDto getUserById(long id) {
    	ConvertDto convertDto = new ConvertDto();
        Optional <User> optionalUser = repositoryUser.findById(id);
        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            return convertDto.convertUserToResponseDTO(user);
        }
        return null;
    }

    @Override
    public ResponseUserDto createUser(RequestUserDto requestUserDto) {
    	ConvertDto convertDto = new ConvertDto();
        User user=objectMapper.convertValue(requestUserDto, User.class);
        repositoryUser.save(user);
        return convertDto.convertUserToResponseDTO(user);
    }

    @Override
    public ResponseUserDto updateUser(long id, RequestUserDto requestUserDto) {
    	ConvertDto convertDto = new ConvertDto();
        User user = repositoryUser.findById(id).orElseThrow(NoSuchElementException::new);
        BeanUtils.copyProperties(requestUserDto, user);
        return convertDto.convertUserToResponseDTO(user);
    }

    @Override
    public String deleteUser(long id) {
        Optional<User> optionalUser = repositoryUser.findById(id);
        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            repositoryUser.delete(user);
            return "id: " + user.getId() + " Eliminated";
        }
        return null;
    }
}
