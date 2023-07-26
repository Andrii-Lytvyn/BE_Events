package de.ait.timepad.dto;

import de.ait.timepad.models.Event;
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
    private Long id;
    private String place;
    private String author;
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
