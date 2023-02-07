package bg.softuni.musicdb.models.dto;

import bg.softuni.musicdb.models.enums.ArtistName;
import bg.softuni.musicdb.models.enums.Genre;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class AddAlbumDTO {
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters.")
    private String name;

    @Size(min = 5, message = "Image url must be minimum 5 characters.")
    private String imageUrl;

    @Min(value = 1, message = "Price must be positive number.")
    @NotNull(message = "Price cannot be empty.")
    private Double price;

    @Min(value = 10, message = "Copies must be more than 10.")
    @NotNull(message = "Copies cannot be empty.")
    private Integer copies;

    @PastOrPresent(message = "Release date cannot be in the future.")
    @NotNull(message = "Release date cannot be empty.")
    private LocalDate releaseDate;

    private String producer;

    @NotNull(message = "You must select artist.")
    private ArtistName artistName;

    @NotNull(message = "You must select genre.")
    private Genre genre;

    @Size(min = 5, message = "Description length must be minimum 5 characters.")
    private String description;
}
