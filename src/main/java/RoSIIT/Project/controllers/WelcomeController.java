package RoSIIT.Project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping(path= "/")
    public String hello1 (Model model){
        return "home";
    }
}
