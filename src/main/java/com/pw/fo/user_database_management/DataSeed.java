package com.pw.fo.user_database_management;

import com.pw.fo.user_database_management.users.User;
import com.pw.fo.user_database_management.users.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

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
        User user1 = new User("Palina",
                "Wierzchowska",
                "paula@paula.pl",
                "Paula");
        userRepository.save(user1);

        User user2 = new User("Joanna",
                "Kowalska",
                "asia@asia.pl",
                "Asia");
        userRepository.save(user2);

        User user3 = new User("Michał",
                "Nowak",
                "mike@mike.pl",
                "Mike");
        userRepository.save(user3);
    }


}
