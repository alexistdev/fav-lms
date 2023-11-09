package com.alexistdev.lmsfav.role;

import com.alexistdev.lmsfav.entity.Role;
import com.alexistdev.lmsfav.repository.RoleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class RoleRepositoryTest {
    @Autowired
    private TestEntityManager em;

    @Autowired
    private RoleRepository roleRepository;

    @Test
    @DisplayName("test same name")
    public void findByName() {
        Date now = new Date();
        Role role = Role.builder()
                .name("admin")
                .description("administrator")
                .status("1")
                .createdAt(now)
                .updatedAt(now)
                .modifiedBy("admin")
                .createdBy("admin")
                .build();
        em.persist(role);
        em.flush();
        var roleFound = roleRepository.findByName(role.getName()).orElse(new Role());
        Assertions.assertSame(role.getName(),roleFound.getName());
    }
}
