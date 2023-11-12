package com.alexistdev.lmsfav.controller;

import com.alexistdev.lmsfav.dto.RoleRequest;
import com.alexistdev.lmsfav.entity.Role;
import com.alexistdev.lmsfav.response.ResponseData;
import com.alexistdev.lmsfav.service.RoleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody RoleRequest roleRequest){
        ResponseData<Role> responseData = new ResponseData<>();
        responseData.setStatus(false);
        try{
            Role result =roleService.add(roleRequest);
            responseData.setStatus(true);
            responseData.setData(result);
            responseData.setMessages("Berhasil");
            return new ResponseEntity<ResponseData<?>>(responseData, HttpStatus.CREATED);
        } catch (Exception e) {
            responseData.setMessages(e.getMessage());
            return new ResponseEntity<ResponseData<?>>(responseData, HttpStatus.BAD_REQUEST);
        }

    }

}
