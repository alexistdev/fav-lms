package com.alexistdev.lmsfav.role;

import com.alexistdev.lmsfav.entity.Role;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EntityRoleTest {
    @Test
    public void role(){
        Role role = new Role();
        role.setId("1");
        Assertions.assertSame("1",role.getId());
    }
}
