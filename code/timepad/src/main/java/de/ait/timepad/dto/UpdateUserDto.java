package de.ait.timepad.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Data for update")
public class UpdateUserDto {
    @Schema(description = "Users role: USER, MANAGER ", example = "MANAGER")
    private String newRole;

    @Schema(description = "Users state - NOT_CONFIRMED, CONFIRMED, BANNED, DELETED", example = "CONFIRMED")
    private String newState;

}
