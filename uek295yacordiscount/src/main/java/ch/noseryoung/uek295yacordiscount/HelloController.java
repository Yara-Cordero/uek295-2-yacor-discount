package ch.noseryoung.uek295yacordiscount;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    public HelloController() {
    }

    @GetMapping("/")
    public String index() {
        return "ABSOLUTE TEST";
    }
}

