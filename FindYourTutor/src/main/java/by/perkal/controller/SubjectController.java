package by.perkal.controller;

import by.perkal.model.Subject;
import by.perkal.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SubjectController {
    @Autowired
    private SubjectService service;

    @GetMapping(value = {"/subjects"})
    public ModelAndView showSubjects(Model model) {
        List<Subject> list = service.listAll();
        ModelAndView mav = new ModelAndView("subjects");
        mav.addObject("subjectList", list);
        return mav;
    }
}
