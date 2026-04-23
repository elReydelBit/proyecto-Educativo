package com.javaeducativo.controller;

import com.javaeducativo.model.JavaLesson;
import com.javaeducativo.service.LessonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WebController {

    private final LessonService lessonService;

    public WebController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("modulos", lessonService.groupByModulo());
        model.addAttribute("totalLecciones", lessonService.list().size());
        return "index";
    }

    @GetMapping("/leccion/{id}")
    public String leccion(@PathVariable String id, Model model) {
        JavaLesson leccion = lessonService.findById(id)
            .orElse(lessonService.list().get(0));
        model.addAttribute("leccion", leccion);

        // lección anterior y siguiente para navegación
        var todas = lessonService.list();
        int idx = todas.indexOf(leccion);
        model.addAttribute("anterior", idx > 0 ? todas.get(idx - 1) : null);
        model.addAttribute("siguiente", idx < todas.size() - 1 ? todas.get(idx + 1) : null);
        return "leccion";
    }
}
