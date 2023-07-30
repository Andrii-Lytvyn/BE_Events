package de.ait.timepad.dto;

import de.ait.timepad.models.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Information about the user in the event")
public class UserInEventDto {
    @Schema(description = "UsersID", example = "1")
    private Long id;

    @Schema(description = "Users email", example = "user@gmail.com")
    private String email;

    public static UserInEventDto from(User user)
    {
        return UserInEventDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .build();
    }

}
