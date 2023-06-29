package com.credibanco.loginback.Controller;

import com.credibanco.loginback.Dto.Request.RequestUserDto;
import com.credibanco.loginback.Dto.Response.ResponseUserDto;
import com.credibanco.loginback.Service.IServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping ("users")
public class ControllerUser {
    @Autowired
    IServiceUser iServiceUser;

    @GetMapping ("get/all")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getAllUser(){
        Map<String, Object> res = new HashMap<>();

        List<ResponseUserDto> responseUserDto = iServiceUser.getAllUsers();
        res.put("status", HttpStatus.OK);
        res.put("data",responseUserDto);
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @GetMapping ("get/id")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getUserById(long id){
        Map<String, Object> res = new HashMap<>();
        List<ResponseUserDto> responseUserDto = iServiceUser.getAllUsers();
        res.put("status", HttpStatus.OK);
        res.put("data",responseUserDto);
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @GetMapping ("create")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> createUser(RequestUserDto requestUserDto){
        Map<String, Object> res = new HashMap<>();
        ResponseUserDto responseUserDto = iServiceUser.createUser(requestUserDto);
        res.put("status", HttpStatus.OK);
        res.put("data",responseUserDto);
        return new ResponseEntity<>(res,HttpStatus.OK);
    }
    @GetMapping ("update")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> updateUser(long id, RequestUserDto requestUserDto){
        Map<String, Object> res = new HashMap<>();

      ResponseUserDto responseUserDto = iServiceUser.updateUser(id, requestUserDto);
        res.put("status", HttpStatus.OK);
        res.put("data",responseUserDto);
        return new ResponseEntity<>(res,HttpStatus.OK);
    }
    @GetMapping ("delete")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> deleteUser(long id){
        Map<String, Object> res = new HashMap<>();

       String responseUserDto = iServiceUser.deleteUser(id);
        res.put("status", HttpStatus.OK);
        res.put("data",responseUserDto);
        return new ResponseEntity<>(res,HttpStatus.OK);
    }



}
