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
    public String login(@Valid @ModelAttribute("user") User user, BindingResult bindingResult,
                        HttpSession session, Model model) {
        if (bindingResult.hasErrors()) {
            return "login";
        }

        if (storeService.findStoreByEmail(user.getEmail()).isPresent()) {
            if (storeService.findStoreByEmail(user.getEmail()).get().getPassword().equals(user.getPassword())) {
                session.setAttribute("currentUser", user);
                return "redirect:/"; //should return to homepage or profile page
            } else {
                model.addAttribute("message", "Wrong password");
                return "login";
            }
        }
        /**
         * Uncomment after CustomerService, InMemoryCustomerService and Customer classes added
         */
//        else if (customerService.findCustomerByEmail(user.getEmail()).isPresent()) {
//            if (customerService.findCustomerByEmail(user.getEmail()).get().getPassword().equals(user.getPassword())) {
//                session.setAttribute("currentUser", user);
//                return "redirect:/"; //should return to homepage or profile page
//            } else {
//                model.addAttribute("message", "Wrong password");
//                return "login";
//            }
//        }
        else {
            model.addAttribute("message", "No such user");
            return "login";
        }
    }
}
