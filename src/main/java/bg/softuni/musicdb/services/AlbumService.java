package bg.softuni.musicdb.services;

import bg.softuni.musicdb.models.dto.AddAlbumDTO;
import bg.softuni.musicdb.models.dto.ShowAlbumDTO;
import bg.softuni.musicdb.models.entities.Album;
import bg.softuni.musicdb.repositories.AlbumRepository;
import bg.softuni.musicdb.repositories.ArtistRepository;
import bg.softuni.musicdb.util.user.CurrentUser;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class AlbumService {
    private final AlbumRepository albumRepository;

    private final ArtistRepository artistRepository;

    private CurrentUser currentUser;

    private final ModelMapper mapper;

    public void addAlbum(AddAlbumDTO albumDTO) {
        Album album = mapper.map(albumDTO, Album.class);
        album.setArtist(artistRepository.findByName(albumDTO.getArtistName()));
        album.setAddedFrom(currentUser.getUser());

        albumRepository.saveAndFlush(album);
    }

    public List<ShowAlbumDTO> allAlbums() {
        return albumRepository.findAll().stream().map(album -> mapper.map(album, ShowAlbumDTO.class))
                .collect(Collectors.toList());
    }

    public int totalSoldCopies() {
        return albumRepository.findAll().stream().map(Album::getCopies).mapToInt(Integer::intValue).sum();
    }

    public void deleteAlbum(Long albumId) {
        albumRepository.deleteById(albumId);
    }
}
