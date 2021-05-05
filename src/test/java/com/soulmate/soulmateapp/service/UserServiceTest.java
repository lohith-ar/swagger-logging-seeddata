package com.soulmate.soulmateapp.service;

import com.soulmate.soulmateapp.domain.SoulmateUser;
import com.soulmate.soulmateapp.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userrepo;

    @InjectMocks
    private UserServiceImpl userserv;



    @Test
    public void givenUsertoSaveThenReturnSavedUser(){
        SoulmateUser user = new SoulmateUser(1,25,"name1","male");

        when(userrepo.save(any())).thenReturn(user);
        userserv.saveUser(user);
        verify(userrepo,times(1)).save(any());
    }

    @Test
    public void givenUsersThenReturnAllUsers(){
        List<SoulmateUser> al = new ArrayList<SoulmateUser>();
        SoulmateUser user = new SoulmateUser(1,25,"name1","male");
        SoulmateUser user1 = new SoulmateUser(2,25,"name2","male");
        al.add(user);
        al.add(user1);

        userrepo.save(user);
        when(userrepo.findAll()).thenReturn(al);
        List<SoulmateUser> al1 = userserv.getAllUsers();
        assertEquals(al1,al);
        verify(userrepo,times(1)).findAll();

    }

//    @Test
//    public void givenUserIdThenshouldDeleteUser(){
//        SoulmateUser user = new SoulmateUser(1,25,"name1","male");
//        userrepo.save(user);
//        when(userserv.deleteUser(user.getId())).thenReturn(user);
//    }

}