package by.tms.web.controller;


import by.tms.entity.Store;
import by.tms.service.CustomerService;
import by.tms.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/store")
public class StoreController {
    private final StoreService storeService;
    private final CustomerService customerService;

    @Autowired
    public StoreController(StoreService storeService, CustomerService customerService) {
        this.storeService = storeService;
        this.customerService = customerService;
    }

    @GetMapping("/storeRegistration")
    public String storeRegistration(@ModelAttribute("newStore") Store store) {
        return "storeRegistration";
    }

    @PostMapping("/storeRegistration")
    public String registration(@Valid @ModelAttribute("newStore") Store store, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "storeRegistration";
        }
        if (storeService.findStoreByEmail(store.getEmail()).isEmpty()
                && customerService.findCustomerByEmail(store.getEmail()).isEmpty()) {
            storeService.saveStore(store);
            return "redirect:/";
        } else {
            model.addAttribute("message", "User already exists");
            return "storeRegistration";
        }
    }
}
