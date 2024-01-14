package com.titamedia.challenge.mapper;

import com.titamedia.challenge.domain.User;
import com.titamedia.challenge.dto.UserDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    UserDto toUserDto(User user);

    List<UserDto> toUserDto(Iterable<User> users);
}
