package de.ait.timepad.controllers;

import de.ait.timepad.models.User;
import de.ait.timepad.repositories.UsersRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("UsersController is works: ")
@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
class UsersControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UsersRepository usersRepository;

    @BeforeEach
    public void setUp() {
        usersRepository.clear();
    }

    @Nested
    @DisplayName("addUser() method is works: ")
    class addUserTests {
        @Test
        void add_user() throws Exception {
            mockMvc.perform(post("/api/users")
                            .header("Content-Type", "application/json")
                            .content("{\n" +
                                    "  \"email\": \"sidikov.marsel@gmail.com\",\n" +
                                    "  \"password\": \"qwerty007\"\n" +
                                    "}"))
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("$.id", is(1)))
                    .andExpect(jsonPath("$.email", is("sidikov.marsel@gmail.com")))
                    .andExpect(jsonPath("$.role", is("USER")))
                    .andExpect(jsonPath("$.state", is("NOT_CONFIRMED")));
        }
    }

    @Nested
    @DisplayName("getAllUsers() method is works: ")
    class GetAllUsersTests {
        @Test
        void get_all_users() throws Exception {
            usersRepository.save(User.builder().state(User.State.NOT_CONFIRMED).role(User.Role.USER).build());
            usersRepository.save(User.builder().state(User.State.NOT_CONFIRMED).role(User.Role.USER).build());

            mockMvc.perform(get("/api/users"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.count", is(2)));
        }


    }


    @Nested
    @DisplayName("deleteUser() method is works: ")
    class DeleteUserTests {


        @Test
        void delete_exists_user() throws Exception {
            usersRepository.save(User.builder().state(User.State.NOT_CONFIRMED).role(User.Role.USER).build());

            mockMvc.perform(delete("/api/users/1"))
                    .andExpect(status().isOk());
            //.andExpect(jsonPath("$.count", is(2)));
        }

        @Test
        void delete_not_exist_user() throws Exception {
            mockMvc.perform(delete("/api/users/1"))
                    .andExpect(status().isNotFound());
        }

    }


    @Nested
    @DisplayName("updateUser() method is works: ")
    class UpdateUserTests{


    }

}