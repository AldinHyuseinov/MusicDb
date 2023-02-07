package bg.softuni.musicdb.models.entities;

import bg.softuni.musicdb.models.enums.Genre;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "albums")
@NoArgsConstructor
@Getter
@Setter
public class Album extends BaseEntity {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String imageUrl;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(nullable = false)
    private Integer copies;

    @Column(columnDefinition = "DECIMAL(19,2)", nullable = false)
    private Double price;

    @Column(nullable = false)
    private LocalDate releaseDate;

    private String producer;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Genre genre;

    @ManyToOne
    private Artist artist;

    @ManyToOne
    private User addedFrom;
}
