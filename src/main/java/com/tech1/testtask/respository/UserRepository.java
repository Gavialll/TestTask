package com.tech1.testtask.respository;

import com.tech1.testtask.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM users where age > ?1 ", nativeQuery = true)
    List<User> usersOlderThan(Integer age);
}
