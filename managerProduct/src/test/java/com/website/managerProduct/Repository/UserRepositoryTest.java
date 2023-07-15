package com.website.managerProduct.Repository;
import com.website.managerProduct.Entity.Role;
import com.website.managerProduct.Entity.User;
import com.website.managerProduct.Repository.User.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTest {
    @Autowired
    UserRepository repo;
    @Autowired
    private TestEntityManager entityManager;
    @Test
    public void testData(){
        Role role1 = entityManager.find(Role.class,1);
        User user = new User("nam2023","nam2023");
        user.addRole(role1);
        repo.save(user);
    }

}
