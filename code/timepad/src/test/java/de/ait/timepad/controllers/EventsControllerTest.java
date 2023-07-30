package de.ait.timepad.controllers;

import de.ait.timepad.models.Event;
import de.ait.timepad.repositories.EventsRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@DisplayName("EventController is works: ")
@SpringBootTest
@AutoConfigureMockMvc
@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
class EventsControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private EventsRepository eventsRepository;

    @BeforeEach
    public void setUp() {
        eventsRepository.clear();
    }

    @Nested
    @DisplayName("getAllEvents() method is works: ")
    class addEventTest {
        @Test
        void add_event() throws Exception {
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
    }


    @Nested
    @DisplayName("getAllEvents() method is works: ")
    class GetAllEventsTests {
        @Test
        void get_all_events() throws Exception {
            eventsRepository.save(Event.builder().status(Event.Status.EXPECTED).build());
            eventsRepository.save(Event.builder().status(Event.Status.EXPECTED).build());

            mockMvc.perform(get("/api/events"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.count", is(2)));
        }


    }


    @Nested
    @DisplayName("deleteEvent() method is works: ")
    class DeleteEventTests {
        @Test
        void delete_exists_event() throws Exception {
            eventsRepository.save(Event.builder().status(Event.Status.EXPECTED).build());

            mockMvc.perform(delete("/api/events/1"))
                    .andExpect(status().isOk());
        }

        @Test
        void delete_not_exist_event() throws Exception {
            mockMvc.perform(delete("/api/events/1"))
                    .andExpect(status().isNotFound());
        }

    }

    ///////////////////////////////////////////////////////////////
    @Nested
    @DisplayName("updateEvent() method is works: ")
    class UpdateEventTests {
        @Test
        void update_exist_event() throws Exception {
            eventsRepository.save(Event.builder().status(Event.Status.EXPECTED).build());

            mockMvc.perform(put("/api/events/1")
                            .header("Content-Type", "application/json")
                            .content("{\n" +
                                    "  \"newStatus\" : \"ENDED\"\n" +
                                    "}"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.id", is(1)))
                    .andExpect(jsonPath("$.status", is("ENDED")));

        }

        @Test
        void update_not_exist_event() throws Exception {
            mockMvc.perform(put("/api/events/1").header("Content-Type", "application/json")
                            .content("{\n" +
                                    "  \"newStatus\" : \"ENDED\"\n" +
                                    "}"))
                    .andExpect(status().isNotFound());

        }
    }
}












