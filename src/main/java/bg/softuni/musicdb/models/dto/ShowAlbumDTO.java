package bg.softuni.musicdb.models.dto;

import bg.softuni.musicdb.models.enums.ArtistName;
import bg.softuni.musicdb.models.enums.Genre;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class ShowAlbumDTO {
    private Long id;

    private String imageUrl;

    private String name;

    private ArtistName artistName;

    private Genre genre;

    private Double price;

    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private LocalDate releaseDate;

    private Integer copies;
}
