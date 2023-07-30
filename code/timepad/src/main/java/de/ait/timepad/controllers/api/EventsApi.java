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
        @Tag(name = "Events")
})
@RequestMapping("api/events")

public interface EventsApi {
    @Operation(summary = "Creating Event")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    EventDto addEvent(@RequestBody NewEventDto newEvent);

    @Operation(summary = "Get all event")
    @GetMapping
    EventsDto getAllEvents();

    @Operation(summary = "Delete Event", description = "Only for admin")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Can't find event", content = {
                    @Content()
            }),
            @ApiResponse(responseCode = "200", description = "Deleted event",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = EventDto.class))
                    })
    })
    @DeleteMapping("/{event-id}")
    EventDto deleteEvent(@Parameter(required = true, description = "ID to delete", example = "2") @PathVariable("event-id") Long eventId);

    @Operation(summary = "Update Event", description = "Update available only for admin")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Can't find event", content = {
                    @Content()
            }),
            @ApiResponse(responseCode = "200", description = "Updated event",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = EventDto.class))
                    })
    })
    @PutMapping("/{event-id}")
    EventDto updateEvent(@Parameter(required = true, description = "ID to update", example = "2")
                         @PathVariable("event-id") Long eventId,
                         @RequestBody UpdateEventDto updateEvent);


}
//TODO Get event be date