package com.example.recipe.cooker.repository;

import com.example.recipe.cooker.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends CrudRepository<User, Long> {

        Boolean existsByUsername(String username);
        Optional<User> findByUsername(String username);
}
