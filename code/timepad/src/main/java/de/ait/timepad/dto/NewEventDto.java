package de.ait.timepad.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Information for adding new user")
@Data
public class NewEventDto {
    private String name;
    private String about;
    private String place;
    private String author;
    private String quantityOfMembers;
    private String description;
    private String photo;
    private String date;

}
