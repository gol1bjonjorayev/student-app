package gol1bjon.developer.springbootapp.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class StudentDTO {
    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String course;
}
