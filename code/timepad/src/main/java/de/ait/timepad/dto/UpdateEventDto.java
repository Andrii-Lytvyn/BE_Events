package de.ait.timepad.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Data for update")
public class UpdateEventDto {

    @Schema(description = "Events status - EXPECTED, ENDED, ARCHIVE ", example = "EXPECTED")
    private String newStatus;

//    @Schema(description = "Events place", example = "Berlin, Hoffner str. 21")
//    private String newPlace;
}
