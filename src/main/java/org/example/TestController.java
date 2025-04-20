package org.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping(value = "/msg/{msg}")
    public String test(@PathVariable String msg) {
        return "Hello World，" + msg;
    }
}
