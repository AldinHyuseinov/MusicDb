package bg.softuni.musicdb.web;

import bg.softuni.musicdb.services.AlbumService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor(onConstructor_ = @Autowired)
public class HomeController {
    private final AlbumService albumService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("totalSoldCopies", albumService.totalSoldCopies());
        model.addAttribute("albums", albumService.allAlbums());

        return "home";
    }
}
