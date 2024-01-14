package com.titamedia.challenge.service;

import com.titamedia.challenge.dto.UserDto;
import com.titamedia.challenge.mapper.UserMapper;
import com.titamedia.challenge.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public List<UserDto> findAll() {
        var users = userRepository.findAll();
        return userMapper.toUserDto(users);
    }
}
