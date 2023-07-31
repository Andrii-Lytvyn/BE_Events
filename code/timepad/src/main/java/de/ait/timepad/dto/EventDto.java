package de.ait.timepad.dto;

import de.ait.timepad.models.Event;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventDto {

    @Schema(description = "Event's ID", example = "1")
    private Long id;

    @Schema(description = "Events place", example = "Berlin, Hoffner str. 21")
    private String place;

    @Schema(description = "Events author", example = "Andrii")
    private String author;

    @Schema(description = "Events status - EXPECTED, ENDED, ARCHIVE ", example = "EXPECTED")
    private String status;

    public static EventDto from(Event event) {
        return EventDto.builder()
                .id(event.getId())
                .place(event.getPlace())
                .author(event.getAuthor())
                .status(event.getStatus().name())
                .build();
    }

    public static List<EventDto> from(List<Event> events) {
        return events.stream()
                .map(EventDto::from)
                .collect(Collectors.toList());
    }


}
