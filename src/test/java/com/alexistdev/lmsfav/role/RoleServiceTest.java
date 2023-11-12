package com.alexistdev.lmsfav.role;

import com.alexistdev.lmsfav.dto.RoleRequest;
import com.alexistdev.lmsfav.entity.Role;
import com.alexistdev.lmsfav.repository.RoleRepository;
import com.alexistdev.lmsfav.service.RoleServiceImplementation;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RoleServiceTest {
    @Mock
    private RoleRepository roleRepository;

    private RoleServiceImplementation roleService;

    private RoleRequest roleRequest;

    @BeforeEach
    public void setup() {
        roleService = new RoleServiceImplementation(roleRepository);
        roleRequest = RoleRequest.builder()
                .name("Admin")
                .description("Administrator")
                .status("1")
                .createdBy("Admin")
                .modifiedBy("Admin")
                .build();
    }

    @DisplayName("Testing for Role Service")
    @Disabled
    @Test
    public void when_save_role_should_return_role_test() throws Exception {

            Role createdRole = roleService.add(roleRequest);
            System.out.println(createdRole.getName());

    }
}
