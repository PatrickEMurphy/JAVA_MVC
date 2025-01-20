package controllers;

import jakarta.validation.Valid;
import models.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import services.AnimalService;

@Controller
@RequestMapping("/animals")
public class AnimalController {
    @Autowired
    private AnimalService animalService;

    // Listar animales
    @GetMapping("/list")
    public String getAnimals(Model model) {
        model.addAttribute("animals", animalService.list());
        return "animals/list";
    }

    // Crear animal (GET)
    @GetMapping("/create")
    public String createAnimalForm(Model model) {
        model.addAttribute("animal", new Animal());
        return "animals/create";
    }

    // Crear animal (POST)
    @PostMapping("/create")
    public String createAnimal(@Valid @ModelAttribute("animal") Animal animal, BindingResult result) {
        if (result.hasErrors()) {
            return "animals/create";
        }
        animalService.addAnimal(animal);
        return "redirect:/animals/list";
    }

    // Editar animal (GET)
    @GetMapping("/edit/{id}")
    public String editAnimalForm(@PathVariable int id, Model model) {
        animalService.getAnimal(id).ifPresentOrElse(
                animal -> model.addAttribute("animal", animal),
                () -> model.addAttribute("error", "Animal no encontrado")
        );
        return "animals/edit";
    }

    // Editar animal (POST)
    @PostMapping("/edit/{id}")
    public String editAnimal(@PathVariable int id, @Valid @ModelAttribute("animal") Animal animal, BindingResult result) {
        if (result.hasErrors()) {
            return "animals/edit";
        }
        animalService.updateAnimal(id, animal);
        return "redirect:/animals/list";
    }

    // Eliminar animal
    @GetMapping("/delete/{id}")
    public String deleteAnimal(@PathVariable int id) {
        animalService.deleteAnimal(id);
        return "redirect:/animals/list";
    }
}
