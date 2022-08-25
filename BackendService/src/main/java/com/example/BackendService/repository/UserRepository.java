package com.example.BackendService.repository;

import com.example.BackendService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query("from User where isDelete = 0")
    List<User> findUserListByIsNotDeleted();

    @Query("from User where email = :email and isDelete = 0")
    User findByEmail(@Param("email") String email);
}
