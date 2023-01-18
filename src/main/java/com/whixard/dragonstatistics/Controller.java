package com.whixad.dragonstatistics;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

        @GetMapping("/")
        public String index() {
            return "tuo padre è morto e tua madre è un uomo";
        }
}
