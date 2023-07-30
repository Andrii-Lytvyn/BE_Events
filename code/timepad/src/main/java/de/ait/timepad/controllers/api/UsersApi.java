package de.ait.timepad.controllers.api;

import de.ait.timepad.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@Tags(value = {
        @Tag(name = "Users")
})
@RequestMapping("/api/users")
public interface UsersApi {

    @Operation(summary = "Creating User", description = "ID generating automatically")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    UserDto addUser(@RequestBody NewUserDto newUser);

    @Operation(summary = "Get all users")
    @GetMapping
    UsersDto getAllUsers();

    @Operation(summary = "Delete User", description = "Only for admin")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Can't find user",
                    content = {
                            @Content()
                    }),
            @ApiResponse(responseCode = "200", description = "Deleted user",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))
                    })
    })
    @DeleteMapping("/{user-id}")
    UserDto deleteUser(@PathVariable("user-id") Long userId);


    @Operation(summary = "Update User", description = "Only for admin")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Can't find user",
                    content = {
                            @Content()
                    }),
            @ApiResponse(responseCode = "403", description = "Role change to ADMIN is not allowed",
                    content = {
                            @Content()
                    }),
            @ApiResponse(responseCode = "200", description = "Updated user",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))
                    })
    })
    @PutMapping("/{user-id}")
    UserDto updateUser(@PathVariable("user-id") Long userId,
                       @RequestBody UpdateUserDto updateUser);

    @Operation(summary = "Получение пользователя", description = "Доступно всем")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Пользователь не найден",
                    content = {
                            @Content()
                    }),
            @ApiResponse(responseCode = "200", description = "Информация о пользователе",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))
                    })
    })

    @GetMapping("/{user-id}")
    UserDto getUser(@Parameter(required = true, description = "Идентификатор пользователя", example = "2")
                    @PathVariable("user-id") Long userId);

    @Operation(summary = "Получение всех статей пользователя", description = "Доступно всем")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Пользователь не найден",
                    content = {
                            @Content()
                    }),
            @ApiResponse(responseCode = "200", description = "Статьи пользователя пользователь",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ArticlesDto.class))
                    })
    })
    @GetMapping("/{user-id}/articles")
    ArticlesDto getArticlesOfUser(@Parameter(required = true, description = "Идентификатор пользователя", example = "2")
                                  @PathVariable("user-id") Long userId);
}
