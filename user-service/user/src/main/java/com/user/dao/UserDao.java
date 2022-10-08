package com.user.dao;

import com.user.entities.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * This layer will be used to talk to the databases
 */
//mapper from entity class to dto
public interface UserDao extends JpaRepository<UserInfoEntity, String> {

}
