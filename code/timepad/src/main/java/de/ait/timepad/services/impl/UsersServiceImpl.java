package de.ait.timepad.services.impl;

import de.ait.timepad.dto.*;
import de.ait.timepad.exceptions.ForbiddenOperationException;
import de.ait.timepad.exceptions.NotFoundException;
import de.ait.timepad.models.User;
import de.ait.timepad.repositories.UsersRepository;
import de.ait.timepad.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static de.ait.timepad.dto.UserDto.from;
import static de.ait.timepad.dto.ArticleDto.from;


@RequiredArgsConstructor
@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    @Override
    public UserDto addUser(NewUserDto newUser) {
        User user = User.builder()
                .email(newUser.getEmail())
                .password(newUser.getPassword())
                .role(User.Role.USER)
                .articles(new ArrayList<>())
                .state(User.State.NOT_CONFIRMED).build();

        usersRepository.save(user);

        return from(user);
    }

    @Override
    public UsersDto getAllUsers() {
//        List<User> users = usersRepository.findAll();
//
//        List<UserDto> dtos = new ArrayList<>();
//
//        for (User user : users) {
//            UserDto userDto = from(user);
//            dtos.add(userDto);
//        }
        List<User> users = usersRepository.findAll();
        return UsersDto.builder()
                .users(from(users))
                .count(users.size())
                .build();
    }

    @Override
    public UserDto deleteUser(Long userId) {
//        Optional<User> user = usersRepository.findById(userId);
//        if (user.isEmpty()) {
//            throw new NotFoundException("User with id <" + userId + "> not found");
//        }
//        usersRepository.delete(user.get());

        User user = getUserFromRepository(userId);
        usersRepository.delete(user);

        return from(user);
    }


    @Override
    public UserDto updateUser(Long userId, UpdateUserDto updateUser) {
        User user = getUserFromRepository(userId);
        if(updateUser.getNewRole().equals("ADMIN")){
            throw new ForbiddenOperationException("Role change to ADMIN is not allowed");
        }
        user.setState(User.State.valueOf(updateUser.getNewState()));
        user.setRole(User.Role.valueOf(updateUser.getNewRole()));
            usersRepository.save(user);
        return from(user);
    }


    private User getUserFromRepository(Long userId) {
        return usersRepository.findById(userId).orElseThrow(
                () -> new NotFoundException("User with id <" + userId + "> not found"));
    }

    @Override
    public UserDto getUser(Long userId) {
        return from(getUserOrThrow(userId));
    }

    @Override
    public ArticlesDto getArticlesOfUser(Long userId) {
        User user = getUserOrThrow(userId);

        return ArticlesDto.builder()
                .articles(from(user.getArticles()))
                .count(user.getArticles().size())
                .build();
    }

    private User getUserOrThrow(Long userId) {
        return usersRepository.findById(userId).orElseThrow(
                () -> new NotFoundException("User with id <" + userId + "> not found"));
    }


}
