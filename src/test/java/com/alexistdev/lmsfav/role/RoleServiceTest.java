package com.alexistdev.lmsfav.role;

import com.alexistdev.lmsfav.dto.RoleRequest;
import com.alexistdev.lmsfav.service.RoleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RoleServiceTest {

    @Autowired
    public RoleService roleService;

    private RoleRequest roleRequest;

    @BeforeEach
    void setUp() {
        roleRequest = new RoleRequest();
        roleRequest.setName("user");
        roleRequest.setDescription("user");
        roleRequest.setStatus("1");
    }

    @Test
    void it_should_save_role() throws Exception {
        var result = roleService.add(roleRequest);
        Assertions.assertSame(result.getName(), roleRequest.getName());
        Assertions.assertNotNull(result);
    }
}
