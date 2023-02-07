package bg.softuni.musicdb.web;

import bg.softuni.musicdb.models.dto.AddAlbumDTO;
import bg.softuni.musicdb.services.AlbumService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/albums")
@AllArgsConstructor(onConstructor_ = @Autowired)
public class AlbumController {
    private final AlbumService albumService;

    @GetMapping("/add")
    public String addAlbum() {
        return "add-album";
    }

    @ModelAttribute("albumModel")
    public AddAlbumDTO initAlbum() {
        return new AddAlbumDTO();
    }

    @PostMapping("/add")
    public String addAlbum(@Valid AddAlbumDTO albumModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("albumModel", albumModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.albumModel",
                    bindingResult);
            return "redirect:/albums/add";
        }
        albumService.addAlbum(albumModel);

        return "redirect:/home";
    }

    @GetMapping("/delete")
    public String deleteAlbum(@RequestParam Long albumId) {
        albumService.deleteAlbum(albumId);

        return "redirect:/home";
    }
}
