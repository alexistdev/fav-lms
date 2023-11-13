package com.alexistdev.lmsfav.service;

import com.alexistdev.lmsfav.dto.RoleRequest;
import com.alexistdev.lmsfav.entity.Role;
import com.alexistdev.lmsfav.exception.DuplicateException;
import com.alexistdev.lmsfav.repository.RoleRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

@Service
@RequiredArgsConstructor
public class RoleServiceImplementation implements RoleService{

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private RoleRepository roleRepository;



    @Override
    public Role add(RoleRequest request) throws DuplicateException {
        Optional<Role> cekRole =roleRepository.findByName(request.getName());

        if(cekRole.isPresent()){
            String name = cekRole.map(Role::getName).orElse(null);
            throw  new DuplicateException(name, ResourceBundle.getBundle("message"));
        }
        Date now = new Date();
        var role = Role.builder()
                .name(request.getName())
                .description(request.getDescription())
                .status(request.getStatus())
                .createdBy(request.getCreatedBy())
                .modifiedBy(request.getModifiedBy())
                .createdAt(now)
                .updatedAt(now)
                .build();
//
//        Role role = new Role();
//        role.setName(request.getName());
//        role.setDescription(request.getDescription());
//        role.setStatus(request.getStatus());
//        role.setCreatedAt(now);
//        role.setUpdatedAt(now);
//        role.setCreatedBy(request.getCreatedBy());
//        role.setModifiedBy(request.getModifiedBy());
        return roleRepository.save(role);
    }
}
