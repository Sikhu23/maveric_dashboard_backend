package com.user.repository;

import com.user.entities.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<UserInfoEntity, Integer> {

	Optional<UserInfoEntity> findById(int Id);

	Optional<UserInfoEntity> findByEmail(String email);

}
