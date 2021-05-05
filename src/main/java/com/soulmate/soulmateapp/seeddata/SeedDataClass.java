package com.soulmate.soulmateapp.seeddata;

import com.soulmate.soulmateapp.domain.SoulmateUser;
import com.soulmate.soulmateapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class SeedDataClass implements CommandLineRunner {

    private UserRepository userrepo;

    @Autowired
    public SeedDataClass(UserRepository userrepo) {
        this.userrepo = userrepo;
    }
//ApplicationListener<ContextRefreshedEvent>
//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//        SoulmateUser user = new SoulmateUser(1,22,"name1","male");
//        SoulmateUser user1 = new SoulmateUser(2,22,"name2","male");
//
//        userrepo.save(user);
//        userrepo.save(user1);
//    }

//CommandLineRunner
    @Override
    public void run(String... args) throws Exception {
        SoulmateUser user = new SoulmateUser(1,22,"name1","m");
        SoulmateUser user1 = new SoulmateUser(2,22,"name2","m");

        userrepo.save(user);
        userrepo.save(user1);
    }
}
