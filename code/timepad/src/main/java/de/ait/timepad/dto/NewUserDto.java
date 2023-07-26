package de.ait.timepad.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 7/21/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Schema(description = "Data for adding new user")
@Data
public class NewUserDto {
    @Schema(description = "E-mail", example = "simple@gmail.com")
    private String email;
    private String password;
}
