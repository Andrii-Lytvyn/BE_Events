package de.ait.timepad.dto;

import lombok.Data;

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
