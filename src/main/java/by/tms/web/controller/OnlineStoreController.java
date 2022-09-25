package by.tms.web.controller;


import by.tms.entity.Store;
import by.tms.entity.User;
import by.tms.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class OnlineStoreController {
    @Autowired
    private StoreService storeService;

    @GetMapping("/storeRegistration")
    public String storeRegistration(@ModelAttribute("newStore") Store store) {
        return "storeRegistration";
    }

    @PostMapping("/storeRegistration")
    public String registration(@Valid @ModelAttribute("newStore") Store store, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "storeRegistration";
        }
        storeService.saveStore(store);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(@ModelAttribute("user") User user) {
        return "login";
    }

    @PostMapping("/login")
    public String login1(@Valid @ModelAttribute("user") User user, BindingResult bindingResult,
                         HttpSession session , Model model) {
        if (bindingResult.hasErrors()) {
            return "login";
        }
        if(storeService.findStoreByEmail(user.getEmail()).isPresent()){
            return "redirect:/";
        }
        else{
            model.addAttribute("message" , "No such user");
            return "login";
        }
    }
}
