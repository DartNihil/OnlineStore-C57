package by.tms.web.controller;

import by.tms.entity.Customer;
import by.tms.entity.Store;
import by.tms.entity.User;
import by.tms.service.CustomerService;
import by.tms.service.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {
    private final StoreService storeService;
    private final CustomerService customerService;

    public UserController(StoreService storeService, CustomerService customerService) {
        this.storeService = storeService;
        this.customerService = customerService;
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
        Optional<Store> store = storeService.findStoreByEmail(user.getEmail());
        Optional<Customer> customer = customerService.findCustomerByEmail(user.getEmail());
        if (store.isPresent()) {
            if (store.get().getPassword().equals(user.getPassword())) {

                session.setAttribute("currentStore", store.get());
                return "redirect:/";

            } else {
                model.addAttribute("message", "Wrong password");
                return "login";
            }
        } else if (customer.isPresent()) {
            if (customer.get().getPassword().equals(user.getPassword())) {
                session.setAttribute("currentCustomer", customer.get());
                return "redirect:/";
            } else {
                model.addAttribute("message", "Wrong password");
                return "login";
            }
        } else {
            model.addAttribute("message", "No such user");
            return "login";
        }
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
