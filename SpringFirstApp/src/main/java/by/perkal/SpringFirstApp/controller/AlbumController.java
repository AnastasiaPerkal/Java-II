package by.perkal.SpringFirstApp.controller;

import by.perkal.SpringFirstApp.model.Album;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.List;

@Controller public class AlbumController {
    private static List<Album> albums = new ArrayList<Album>();
    static {
        albums.add(new Album("Full Stack Development with JHipster", "Deepu K Sasidharan, Sendil Kumar N"));
        albums.add(new Album("Pro Spring Security", "Carlo Scarioni, Massimo Nardone")); }
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
    return modelAndView;
    }
}