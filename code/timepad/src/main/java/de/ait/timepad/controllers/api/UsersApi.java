package de.ait.timepad.controllers.api;

import de.ait.timepad.dto.NewUserDto;
import de.ait.timepad.dto.UpdateUserDto;
import de.ait.timepad.dto.UserDto;
import de.ait.timepad.dto.UsersDto;
import io.swagger.v3.oas.annotations.Operation;
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

}
