package com.soulmate.soulmateapp.repository;

import com.soulmate.soulmateapp.domain.SoulmateUser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest
//@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userrepo;

    @Test
    public void givenUserToSaveShouldReturnSavedUser(){
        SoulmateUser user = new SoulmateUser(1,25,"name1","male");
        userrepo.save(user);
        SoulmateUser user1 = userrepo.findById(user.getId()).get();
        assertNotNull(user1);
        assertEquals(user.getName(), user1.getName());
    }

    @Test
    public void givenUsersTogetAllUsers(){
        SoulmateUser user = new SoulmateUser(1,25,"name1","male");
        SoulmateUser user1 = new SoulmateUser(2,25,"name2","male");
        userrepo.save(user);
        userrepo.save(user1);

        List<SoulmateUser> allusers = (List<SoulmateUser>) userrepo.findAll();
        assertEquals(user.getName(), allusers.get(0).getName());
    }

    @Test
    public void giveUserIdtoDeleteThenShouldDeleteUser(){
        SoulmateUser user = new SoulmateUser(1,25,"name1","male");
        userrepo.save(user);
        userrepo.deleteById(user.getId());
        Optional opt = userrepo.findById(user.getId());
        assertEquals(Optional.empty(), opt);
    }




}