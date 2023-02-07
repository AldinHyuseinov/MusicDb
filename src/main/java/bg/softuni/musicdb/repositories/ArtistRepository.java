package bg.softuni.musicdb.repositories;

import bg.softuni.musicdb.models.entities.Artist;
import bg.softuni.musicdb.models.enums.ArtistName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
    Artist findByName(ArtistName name);
}
