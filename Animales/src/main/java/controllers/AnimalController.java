package controllers;

import models.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import services.AnimalService;

@Controller
public class AnimalController {
    @Autowired
    private AnimalService as;

    // Si no usamos Autowired:
    /*public MainController(AnimalService as){
        this.as = as;
    }*/

    // Index
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("pageTitle", "Inicio");
        return "index";
    }

    // Get animals
    @GetMapping("/animals/list")
    public String getAnimals(Model model) {
        model.addAttribute("animals", as.List());
        return "animals/list";
    }

    // Create Get
    @GetMapping("/animals/create")
    public String createAnimal(Model model){
        Animal animal = new Animal(1, "Hola", 1, true);
        model.addAttribute("animal",animal);
        return "animals/create";
    }

    // Create Post
    @PostMapping("/animals/create")
    public String createAnimal(@ModelAttribute("animal") Animal animal){
        return "redirect:/animals/list";
    }
}
