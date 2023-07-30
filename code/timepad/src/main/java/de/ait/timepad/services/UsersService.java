package de.ait.timepad.services;

import de.ait.timepad.dto.*;
import de.ait.timepad.models.User;

public interface UsersService {
    UserDto addUser(NewUserDto newUser);

    UsersDto getAllUsers();

    UserDto deleteUser(Long userId);

    UserDto updateUser(Long userId, UpdateUserDto updateUser);
    UserDto getUser(Long userId);
    ArticlesDto getArticlesOfUser(Long userId);
}
