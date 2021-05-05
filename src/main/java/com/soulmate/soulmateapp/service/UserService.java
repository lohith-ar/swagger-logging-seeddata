package com.soulmate.soulmateapp.service;

import com.soulmate.soulmateapp.domain.SoulmateUser;

import java.util.List;

public interface UserService {

    public SoulmateUser saveUser(SoulmateUser user);
    public List<SoulmateUser> getAllUsers();
    public SoulmateUser updateUser(Integer id, SoulmateUser user);
    public String deleteUser(int id);
    public List<SoulmateUser> getAllUsersbyGender(String gender);
    public List<SoulmateUser> getAllUsersbyAge(int age);
    public List<SoulmateUser> getAllUsersbyName(String name);





}
