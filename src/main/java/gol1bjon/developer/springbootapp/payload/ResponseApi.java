package gol1bjon.developer.springbootapp.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseApi {
    private String message;
    private boolean success;
}
