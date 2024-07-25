package com.alexistdev.lmsfav.service;

import com.alexistdev.lmsfav.dto.RoleRequest;
import com.alexistdev.lmsfav.entity.Role;
import org.springframework.stereotype.Service;


public interface RoleService {
    Role add(RoleRequest role) throws Exception;
}
