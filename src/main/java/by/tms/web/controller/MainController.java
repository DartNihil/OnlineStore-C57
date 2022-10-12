package by.tms.web.controller;

import by.tms.entity.Customer;
import by.tms.entity.Store;
import by.tms.entity.User;
import by.tms.service.CustomerService;
import by.tms.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
                session.setAttribute("currentUser", store.get());
                return "redirect:/";
            } else {
                model.addAttribute("message", "Wrong password");
                return "login";
            }
        } else if (customer.isPresent()) {
            if (customer.get().getPassword().equals(user.getPassword())) {
                session.setAttribute("currentUser", customer.get());
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
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:/";
    }
}