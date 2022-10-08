package com.user.service;

import com.user.dto.UserDTO;
import com.user.entities.UserInfoEntity;


public interface UserService {
    public UserInfoEntity saveUserDetails(UserDTO userDTO);

    public UserInfoEntity getUserDetails(int id);

}
