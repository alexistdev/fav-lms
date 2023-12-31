package com.alexistdev.lmsfav.role;

import com.alexistdev.lmsfav.entity.Role;
import com.alexistdev.lmsfav.repository.RoleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class RoleRepositoryTest {
    @Autowired
    private TestEntityManager em;

    @Autowired
    private RoleRepository roleRepository;

    private Role role;

    @BeforeEach
    void SetUp(){
        Date now = new Date();
        role = Role.builder()
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
    }

    @Test
    @DisplayName("test find By Name")
    public void findByNameTest() {
        var roleFound = roleRepository.findByName(role.getName()).orElse(new Role());
        Assertions.assertSame(role.getName(),roleFound.getName());
    }


}
