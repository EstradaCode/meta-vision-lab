package com.metavisionlab.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/saludo")
    public String Saludo(){
        return "hola amiguo!!";
    }
    @GetMapping("/saludo{nombre}")
    public String saludoPersonalizado(@PathVariable String nombre) {
        return "Hola " + nombre + "!!";
    }
}
