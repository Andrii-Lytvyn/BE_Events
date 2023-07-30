package de.ait.timepad.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Event {
    public enum Status {
        EXPECTED,
        ENDED,
        ARCHIVE
    }
    private Long id;
    private String name;
    private Integer quantityOfMembers;
    private String place;
    private String description;
    private String author;
    private String photo;
    private Status status;
    private String date;

    private List<Event> events;
}
