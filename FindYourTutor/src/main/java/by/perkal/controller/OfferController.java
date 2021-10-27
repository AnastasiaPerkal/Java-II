package by.perkal.controller;

import by.perkal.model.Offer;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class OfferController {
    @GetMapping("/editoffer")
    public String newPerson(@ModelAttribute("offer") Offer offer) {
        return "editoffer";
    }

    @PostMapping("/editoffer")
    public String create(@ModelAttribute("offer") @Valid Offer offer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editoffer";
        }
        return "redirect:/";
    }
}
