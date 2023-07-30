package de.ait.timepad.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 7/27/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Data
@Schema(description = "Adding Article")
public class NewArticleDto {

    @Schema(description = "Article's text", example = "Text about user...")
    private String text;

    @Schema(description = "Users ID", example = "1")
    private Long aboutUserId;

    @Schema(description = "Publishing date in format YYYY-MM-DD", example = "2022-02-02")
    private String publishDate;
}