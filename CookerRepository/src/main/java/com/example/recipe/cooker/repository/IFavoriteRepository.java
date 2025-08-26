package com.example.recipe.cooker.repository;

import com.example.recipe.cooker.entity.Favorite;
import com.example.recipe.cooker.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IFavoriteRepository extends CrudRepository<Favorite, Long> {

  List<Favorite> findByUser(User user);

  Boolean existsByUser(User user);

  Optional<Favorite> findByUserIdAndRecipeId(Long id, Long id1);

  boolean existsByUserIdAndRecipeId(Long id, Long id1);


}
