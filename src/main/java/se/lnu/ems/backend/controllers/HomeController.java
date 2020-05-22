package se.lnu.ems.backend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("HomeController")
@RequestMapping("")
public class HomeController {

    @GetMapping(value = {"", "/{path:[^.]*}", "/**/{path:^(?!oauth|api).*}/{path:[^.]*}"})
    public String welcome() {
        return "index";
    }
}