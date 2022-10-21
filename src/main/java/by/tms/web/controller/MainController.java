package by.tms.web.controller;

import by.tms.entity.Customer;
import by.tms.entity.Store;
import by.tms.entity.User;
import by.tms.service.CustomerService;
import by.tms.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
    private final StoreService storeService;

    private final CustomerService customerService;

    @Autowired
    public MainController(StoreService storeService, CustomerService customerService) {
        this.storeService = storeService;
        this.customerService = customerService;
    }

    @PostMapping
    public String homepageSearch(String searchProduct, Model model) {
        return "redirect: /search";
    }

    @GetMapping("/login")
    public String login(@ModelAttribute("user") User user) {
        return "login";
    }
}