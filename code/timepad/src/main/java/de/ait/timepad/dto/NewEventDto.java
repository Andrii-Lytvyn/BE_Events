package de.ait.timepad.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Information for adding new event")
@Data
public class NewEventDto {
    @Schema(description = "Even's title", example = "Title about event...")
    private String name;
    @Schema(description = "Text about event", example = "Text about event...")
    private String about;
    @Schema(description = "Event's place", example = "Berlin, Kirchweg str., 13")
    private String place;
    @Schema(description = "Events author", example = "Andrii")
    private String author;
    @Schema(description = "Planned number of participants", example = "182")
    private Integer quantityOfMembers;//int
    @Schema(description = "Description of event", example = "Ex. dress-code, or food")
    private String description;
    @Schema(description = "Address of photo", example = "./src/photo/photo12.png")
    private String photo;
    @Schema(description = "Publishing date in format YYYY-MM-DD", example = "2022-02-02")
    private String date;

}
