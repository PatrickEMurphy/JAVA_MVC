package es.cifpcm.SpringEje4.controllers;

import es.cifpcm.SpringEje4.models.Animal;
import es.cifpcm.SpringEje4.services.AnimalService;
import es.cifpcm.SpringEje4.services.AnimalServiceDB;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AnimalController {
    @Autowired
    private AnimalService as;

    @GetMapping("/animals")
    public String index(@NotNull Model model){
        model.addAttribute("animales", as.getAnimals());
        return "animales/index";
    }

    @GetMapping("/animals/details/{id}")
    public String details(@PathVariable int id, Model model){
        model.addAttribute("animal", as.getAnimal(id));

        return "animales/details";
    }

    @GetMapping("/animals/create")
    public String create(Model model){
        model.addAttribute("animal", new Animal());

        return "animales/create";
    }

    @PostMapping("/animals/create")
    public String create(@Valid @ModelAttribute("animal") Animal animal, BindingResult bindingResult){
        if(!bindingResult.hasErrors()) {
            as.addAnimal(animal);
            return "redirect:/animals";
        }else{
            return "animales/create";
        }
    }

    @GetMapping("/animals/edit/{id}")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("animal", as.getAnimal(id));

        return "animales/edit";
    }

    @PostMapping("/animals/edit")
    public String edit(@Valid @ModelAttribute("animal") Animal animal, BindingResult bindingResult){
        if(!bindingResult.hasErrors()){
            as.editAnimal(animal);
            return "redirect:/animals";
        }
        return "animales/edit";
    }

    @GetMapping("/animals/delete/{id}")
    public String delete(@PathVariable int id, Model model){
        Animal animal = as.getAnimal(id);

        if(animal != null){
            model.addAttribute("animal", animal);
            return "animales/delete";
        }

        return "redirect:/animals";
    }

    @PostMapping("/animals/delete")
    public String delete(@ModelAttribute("animal") Animal animal){
        as.deleteAnimal(animal.getId());

        return "redirect:/animals";
    }
}
