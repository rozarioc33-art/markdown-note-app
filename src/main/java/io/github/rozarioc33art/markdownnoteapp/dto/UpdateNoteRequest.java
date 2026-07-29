package io.github.rozarioc33art.markdownnoteapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateNoteRequest {

    @NotBlank(message = "Title cannot be blank")
    @Size(max =  100, message = "Title cannot exceed 100 characters")
    private String title;

    @NotBlank(message = "Content cannot be blank")
    private String content;
}
