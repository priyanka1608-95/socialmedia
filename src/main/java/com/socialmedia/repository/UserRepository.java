package com.socialmedia.repository;

import com.socialmedia.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

   User findByEmailAndPassword(String email, String password);
}