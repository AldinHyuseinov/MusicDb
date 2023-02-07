package bg.softuni.musicdb.models.entities;

import bg.softuni.musicdb.models.enums.ArtistName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "artists")
@NoArgsConstructor
@Getter
@Setter
public class Artist extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ArtistName name;

    @Column(columnDefinition = "TEXT")
    private String careerInformation;
}
