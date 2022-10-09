package by.tms.web.controller;

import by.tms.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/homepage")
public class HomepageController {

    @GetMapping
    public String homepage(){
        return "homepage";
    }

    @PostMapping
    public String homepageSearch(String searchProduct, Model model){
        return "redirect: /search";
    }

    @GetMapping("/login")
    public String login(@ModelAttribute("user") User user) {
        return "redirect: /login";
    }
}
