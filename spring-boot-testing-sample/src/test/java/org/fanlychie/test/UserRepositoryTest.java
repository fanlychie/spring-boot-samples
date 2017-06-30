package org.fanlychie.test;

import org.fanlychie.dao.UserRepository;
import org.fanlychie.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by fanlychie on 2017/6/30.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void save() {
        User user = new User();
        user.setName("fanlychie");
        userRepository.save(user);
        System.out.println(userRepository.findAll());
    }

}