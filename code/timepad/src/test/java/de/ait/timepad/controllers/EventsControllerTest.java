package de.ait.timepad.controllers;

import de.ait.timepad.models.Event;
import de.ait.timepad.models.User;
import de.ait.timepad.repositories.EventsRepository;
import de.ait.timepad.repositories.UsersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.hamcrest.Matchers.is;

@SpringBootTest
@AutoConfigureMockMvc
class EventsControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private EventsRepository eventsRepository;

    @BeforeEach
    public void setUp() {
        eventsRepository.clearEvents();
    }

    @Test
    void addEvent() throws Exception {
        mockMvc.perform(post("/api/events")
                        .header("Content-Type", "application/json")
                        .content("\n" +
                                "{\n" +
                                "  \"name\": \"Circus\",\n" +
                                "  \"description\": \"Kids circus\",\n" +
                                "  \"author\": \"Andrii\",\n" +
                                "  \"place\": \"Bremen, CircusHof, 11\",\n" +
                                "  \"quantityOfMembers\": \"250\",\n" +
                                "  \"photo\": \"added photo #2\",\n" +
                                "  \"date\": \"01/09/2023\"\n" +
                                "\n" +
                                "}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.place", is("Bremen, CircusHof, 11")))
                .andExpect(jsonPath("$.author", is("Andrii")))
                .andExpect(jsonPath("$.status", is("EXPECTED")));
    }

    //TODO тесты для евентов дописать
}




