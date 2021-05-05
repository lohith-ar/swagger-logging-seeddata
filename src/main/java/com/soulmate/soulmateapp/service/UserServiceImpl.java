package com.soulmate.soulmateapp.service;

import com.soulmate.soulmateapp.domain.SoulmateUser;
import com.soulmate.soulmateapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userrepo;

    @Autowired
    public UserServiceImpl(UserRepository userrepo) {
        this.userrepo = userrepo;
    }

    @Override
    public SoulmateUser saveUser(SoulmateUser user) {
        return userrepo.save(user);
    }

    @Override
    public List<SoulmateUser> getAllUsers() {
        return (List<SoulmateUser>) userrepo.findAll();
    }

    @Override
    public SoulmateUser updateUser(Integer id, SoulmateUser user) {
        Optional<SoulmateUser> user1= userrepo.findById(id);
        user.setId(id);
        return userrepo.save(user);
    }

    @Override
    public String deleteUser(int id) {
        Optional<SoulmateUser> user1= userrepo.findById(id);
        userrepo.deleteById(id);
        return "Deleted";
    }

    @Override
    public List<SoulmateUser> getAllUsersbyGender(String gender) {

        return userrepo.getUsersByGender(gender);
    }

    @Override
    public List<SoulmateUser> getAllUsersbyAge(int age) {
        return userrepo.getUsersByAge(age);
    }

    @Override
    public List<SoulmateUser> getAllUsersbyName(String name) {
        return userrepo.getUsersByName(name);
    }


}
