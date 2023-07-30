package de.ait.timepad.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventsDto {
    @Schema(description = "List of users events")
    private List<EventDto> events;
    @Schema(description = "Number of users events")
    private Integer count;
}


