package dev.al.internship.controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messages")
public class MssgController {


    @GetMapping("/mssg")
    public String getStaticMessage() {
        return "Mesazhi statik";
    }

    @PostMapping("/greet")
    public String greetByLanguage(@RequestParam String language) {

        switch (language.toLowerCase()) {
            case "en":
                return "Hello!";
            case "sq":
                return "Pershendetje!";
            case "es":
                return "¡Hola!";
            case "fr":
                return "Bonjour!";
            default:
                return "Gjuha jo e perfshire ne perkthim!";
        }
    }
}
