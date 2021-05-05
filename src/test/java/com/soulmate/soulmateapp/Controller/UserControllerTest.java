package com.soulmate.soulmateapp.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.soulmate.soulmateapp.domain.SoulmateUser;
import com.soulmate.soulmateapp.repository.UserRepository;
import com.soulmate.soulmateapp.service.UserService;
import com.soulmate.soulmateapp.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @Mock
    private UserService userServ;

    private SoulmateUser smUser;
    private List<SoulmateUser> userList;

    @InjectMocks
    private UserController userCont;

    @BeforeEach
    public void beforeEach(){
        smUser = new SoulmateUser(1,25,"name1","male");
        mvc = MockMvcBuilders.standaloneSetup(userCont).build();
    }

    @Test
    public void givenUsertoSaveThenReturnSavedUser() throws Exception {
        when(userServ.saveUser(any())).thenReturn(smUser);
        mvc.perform(post("/api/v1/adduser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(smUser)))
                .andExpect(status().isCreated());
        verify(userServ,times(1)).saveUser(any());
    }
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void givenGetRequestThenReturnAllUsers() throws Exception{
        when(userServ.getAllUsers()).thenReturn(Arrays.asList(new SoulmateUser(1,25,"name1","male"),
                new SoulmateUser(2,25,"name2","male")));
        mvc.perform(get("/api/v1/allusers")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[{id:1,name:name1}, {id:2,name:name2}]"))
                .andExpect(status().isOk());
        verify(userServ,times(1)).getAllUsers();
    }


//    @Test
//    public void givenUserInfoThenReturnUpdatedUser() throws Exception {
//        SoulmateUser user1 = new SoulmateUser(1,22,"old_name", "male");
//        when(userServ.updateUser(user1.getId(), user1)).thenReturn(smUser);
//        mvc.perform(put("/api/v1/updateuser/{id}", user1.getId())
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(asJsonString(smUser)))
//                .andExpect(content().json("{id:1,name:name1}"))
//                .andExpect(status().isOk());
//        verify(userServ,times(1)).updateUser(user1.getId(), smUser);
//    }

    @Test
    public void giveUserIdMustReturnSuccessOnDeletion() throws Exception {
        when(userServ.deleteUser(smUser.getId())).thenReturn("Deleted");
        mvc.perform(delete("/api/v1/deleteuser/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(userServ,times(1)).deleteUser(smUser.getId());
    }







}