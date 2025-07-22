package com.metavisionlab.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String Saludo(){
        return "hola amiguo!!";
    }
    @GetMapping("/saludo")
    public String saludoPersonalizado(@RequestParam(defaultValue = "amiguo") String nombre) {
        return "Hola " + nombre + "!!";
    }
}
