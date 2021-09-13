package by.perkal.SpringFirstApp.controller;

import by.perkal.SpringFirstApp.forms.AlbumForm;
import by.perkal.SpringFirstApp.model.Album;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller public class AlbumController {
    private static List<Album> albums = new ArrayList<Album>();
    static int id = 0;

    static {
        albums.add(new Album(id++,"Full Stack Development with JHipster", "Deepu K Sasidharan, Sendil Kumar N"));
        albums.add(new Album(id++,"Pro Spring Security", "Carlo Scarioni, Massimo Nardone"));
    }

    // // Вводится (inject) из application.properties.
    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public ModelAndView index(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        model.addAttribute("message", message);
        log.info("/index was called");
        return modelAndView;
    }

    @RequestMapping(value = {"/allalbums"}, method = RequestMethod.GET)
    public ModelAndView albumList(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("albumlist");
        model.addAttribute("albums", albums);
        log.info("/allalbums was called");
        return modelAndView;
    }

    @RequestMapping(value = {"/addalbum"}, method = RequestMethod.GET)
    public ModelAndView showAddPersonPage(Model model) {
        ModelAndView modelAndView = new ModelAndView("addalbum");
        AlbumForm albumForm = new AlbumForm();
        model.addAttribute("albumform", albumForm);
        log.info("/addalbum was called");
        return modelAndView;
    }

//    @RequestMapping(value = {"/save"}, method = RequestMethod.GET)
//    public ModelAndView saveEditChanges(Model model) {
//        ModelAndView modelAndView = new ModelAndView("addalbum");
//        AlbumForm albumForm = new AlbumForm();
//        model.addAttribute("albumform", albumForm);
//        log.info("/save was called");
//        return modelAndView;
//    }

    // @PostMapping("/addbook") //GetMapping("/")
    @RequestMapping(value = {"/addalbum"}, method = RequestMethod.POST)
    public ModelAndView savePerson(Model model, @ModelAttribute("albumform") AlbumForm albumForm) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("albumlist");
        String title = albumForm.getTitle();
        String author = albumForm.getAuthor();
        if (title != null && title.length() > 0 && author != null && author.length() > 0) {
            Album newAlbum = new Album(id++, title, author);
            albums.add(newAlbum);
            model.addAttribute("albums", albums);
            return modelAndView;
        }
        model.addAttribute("errorMessage", errorMessage);
        modelAndView.setViewName("addalbum");
        return modelAndView;
    }
    @GetMapping("/deletealbum")
    public ModelAndView deletePerson(Model model, @RequestParam int id) {
        ModelAndView modelAndView = new ModelAndView("albumlist");
        albums.removeIf(x -> x.getId() == id);
        model.addAttribute("albums", albums);
       log.info("person with id = " + id + " has been deleted");
        return modelAndView;
    }

    @GetMapping("/editalbum")
    public ModelAndView showEditPersonPage(Model model, @RequestParam int id) {
        ModelAndView modelAndView = new ModelAndView("editalbum");
        Optional<Album> optionalPerson = albums.stream().filter(a -> a.getId() == id).findFirst();
        if (optionalPerson.isPresent()) {
            Album personToEdit = optionalPerson.get();
            model.addAttribute("id", personToEdit.getId());
            AlbumForm personForm = new AlbumForm(personToEdit.getTitle(), personToEdit.getAuthor());
            model.addAttribute("album_form", personForm);
            log.info("going to edit page");
        }
        return modelAndView;
    }

    @PostMapping("/editalbum")
    public ModelAndView saveEditedPerson(Model model, @ModelAttribute("album_form") AlbumForm albumForm, @RequestParam int id) {
        ModelAndView modelAndView = new ModelAndView();
        String newAuthor = albumForm.getAuthor();
        String newTitle = albumForm.getTitle();
        if (newAuthor != null && newAuthor.length() > 0 && newTitle != null && newTitle.length() > 0) {
            modelAndView.setViewName("albumlist");
            Optional<Album> optionalAlbum = albums.stream().filter(a -> a.getId() == id).findFirst();
            if (optionalAlbum.isPresent()) {
                Album albumToEdit = optionalAlbum.get();
                albumToEdit.setAuthor(newAuthor);
                albumToEdit.setTitle(newTitle);
            }
            model.addAttribute("albums", albums);
           log.info("person with id = " + id + " has been edited");
            return modelAndView;
        }
        model.addAttribute("errorMessage", errorMessage);
        modelAndView.setViewName("editalbum");
        return modelAndView;
    }
}
