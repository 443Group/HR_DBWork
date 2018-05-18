package HRMS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping(value = "/error")
    public String getUserName(){
        return "redirect:/404.html";
    }

}
