package com.whixard.dragonstatistics;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

        @GetMapping("/")
        public String index() {
            return "<h1>DragonStatistcs API</h1>";
        }
}
