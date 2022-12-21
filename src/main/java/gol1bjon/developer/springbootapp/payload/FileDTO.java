package gol1bjon.developer.springbootapp.payload;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FileDTO {

    private Long id;
    private Long fileSize;
    private String originalName;
    private String generatedName;
    private String extension;
    private String url;

}
