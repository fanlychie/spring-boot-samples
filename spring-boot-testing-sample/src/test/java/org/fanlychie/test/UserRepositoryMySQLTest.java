package org.fanlychie.test;

import org.fanlychie.dao.UserRepository;
import org.fanlychie.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by fanlychie on 2017/6/30.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UserRepositoryMySQLTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Rollback(false)
    public void testSave() {
        User user = new User();
        user.setName("fanlychie");
        userRepository.save(user);
        System.out.println("====================================");
        System.out.println(userRepository.findAll());
        System.out.println("====================================");
    }

    @Test
    @Transactional(readOnly = true)
    public void testSelect() {
        System.out.println("====================================");
        System.out.println(userRepository.findAll());
        System.out.println("====================================");
    }

}