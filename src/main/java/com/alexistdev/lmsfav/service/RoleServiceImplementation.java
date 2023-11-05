package com.alexistdev.lmsfav.service;

import com.alexistdev.lmsfav.dto.RoleRequest;
import com.alexistdev.lmsfav.entity.Role;
import com.alexistdev.lmsfav.exception.DuplicateException;
import com.alexistdev.lmsfav.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

@Service
public class RoleServiceImplementation implements RoleService{

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role add(RoleRequest request) throws Exception {
        Optional<Role> cekRole =roleRepository.findByName(request.getName());
        if(cekRole.isPresent()){
            String name = cekRole.map(Role::getName).orElse(null);
            throw  new DuplicateException(name, ResourceBundle.getBundle("message"));
        }
        Date now = new Date();
        var role = Role.builder()
                .name(request.name)
                .description(request.description)
                .status(request.status)
                .createdBy(request.createdBy)
                .modifiedBy(request.modifiedBy)
                .createdAt(now)
                .updatedAt(now)
                .build();
        return roleRepository.save(role);
    }
}
