package com.pw.fo.user_database_management;

import com.pw.fo.user_database_management.users.User;
import com.pw.fo.user_database_management.users.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataSeed implements InitializingBean {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void afterPropertiesSet() throws Exception {
        addUsers();
    }

    private void addUsers() {
        if (userRepository.count() != 0) {
            return;
        }
        User user1 = new User("Paulina",
                "Wierzchowska",
                "Paula",
                "paula@paula.pl");
        userRepository.save(user1);

        User user2 = new User("Joanna",
                "Kowalska",
                "Asia",
                "asia@asia.pl");
        userRepository.save(user2);

        User user3 = new User("Michał",
                "Nowak",
                "Mike",
                "mike@mike.pl");
        userRepository.save(user3);
    }
}