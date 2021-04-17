package com.pw.fo.user_database_management.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE LOWER(u.firstName) LIKE LOWER(CONCAT('%', ?1, '%')) OR LOWER(u.lastName) LIKE LOWER(CONCAT('%', ?1, '%')) OR LOWER(u.nick) LIKE LOWER(CONCAT('%', ?1, '%'))")
    List<User> findUsersByPhrase(String userPhrase);

    @Query("SELECT u FROM User u WHERE LOWER(u.nick) LIKE LOWER(CONCAT(?1, '%'))")
    List<User> findUsersByNick(String userNick);

    @Query("SELECT u FROM User u WHERE u.id=?1")
    List<User> findUserById(Integer userId);

}
