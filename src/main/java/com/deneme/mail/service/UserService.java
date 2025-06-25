package com.deneme.mail.service;

import com.deneme.mail.dto.UserResponse;
import com.deneme.mail.entity.User;
import com.deneme.mail.repository.UserRepository;
import com.deneme.mail.service.base.AbstractService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService extends AbstractService<User> {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    protected UserRepository getRepository() { return userRepository; }

    public User findById(Long id) {
        return super.findById(id);
    }

    public UserResponse findByUsername(String username){
        User user = getRepository().findByUsername(username);
        return modelMapper.map(user, UserResponse.class);
    }

    public UserResponse findByEmail(String email){
        User user = getRepository().findByEmail(email);
        return modelMapper.map(user, UserResponse.class);
    }
}

