package io.github.rozarioc33art.markdownnoteapp.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private List<String> messages;

}
