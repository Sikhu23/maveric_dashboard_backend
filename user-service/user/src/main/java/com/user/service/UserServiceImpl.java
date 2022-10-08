package com.user.service;

import com.user.dao.UserDao;
import com.user.dto.UserDTO;
import com.user.entities.UserInfoEntity;
import com.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private UserDao userDao;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public UserInfoEntity saveUserDetails(UserDTO userDTO) {

        Optional<UserInfoEntity> emailIDExist = userRepository.findByEmail(userDTO.getEmail());
        if (!emailIDExist.isPresent()) {
            UserInfoEntity createNewUser = modelMapper.map(userDTO, UserInfoEntity.class);
             return userDao.save(createNewUser);
        }
        throw new EntityNotFoundException("Email id already exists");
     }

    @Override
    public UserInfoEntity getUserDetails(int id) {
        Optional<UserInfoEntity> isIDExist = userRepository.findById(id);
        if (isIDExist.isPresent()) {
             return userDao.getById(String.valueOf(id));
        }
        throw new EntityNotFoundException("id does not exists");
    }
}
