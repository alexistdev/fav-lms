package com.alexistdev.lmsfav.role;

import com.alexistdev.lmsfav.dto.RoleRequest;
import com.alexistdev.lmsfav.entity.Role;
import com.alexistdev.lmsfav.repository.RoleRepository;
import com.alexistdev.lmsfav.service.RoleServiceImplementation;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import java.util.Date;

@ExtendWith(MockitoExtension.class)
public class RoleServiceTest {
    @InjectMocks
    private RoleServiceImplementation roleService;

    @Mock
    private RoleRepository roleRepository;


    @DisplayName("Testing for Role Service")
    @Test
    public void should_save_one_role() throws Exception {

        Date now = new Date();
       final Role roleToSave = Role.builder()
                .name("Admin")
                .description("Administrator")
                .status("1")
                .createdBy("Admin")
                .modifiedBy("Admin")
                .createdAt(now)
                .updatedAt(now)
                .build();

       lenient().when(roleRepository.save(any(Role.class))).thenReturn(roleToSave);

        final var actual = roleService.add(new RoleRequest());
        assertThat(actual).usingRecursiveComparison().isEqualTo(roleToSave);
        verify(roleRepository, times(1)).save(any(Role.class));
    }
}
