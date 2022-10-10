package by.tms.web.controller;

import by.tms.entity.Customer;
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
@RequestMapping("/customer")
public class OnlineCustomerController {
    @Autowired
    private CustomerService customerService;

    private final StoreService storeService;

    @Autowired
    public OnlineCustomerController(CustomerService customerService, StoreService storeService) {
        this.customerService = customerService;
        this.storeService = storeService;
    }

    @GetMapping("/customerRegistration")
    public String CustomerRegistration(@ModelAttribute("newCustomer") Customer customer) {
        return "customerRegistration";
    }

    @PostMapping("/customerRegistration")
    public String registration(@Valid @ModelAttribute("newCustomer") Customer customer, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "customerRegistration";
        }
        if (customerService.findCustomerByEmail(customer.getEmail()).isEmpty()
                && storeService.findStoreByEmail(customer.getEmail()).isEmpty()) {
            customerService.saveCustomer(customer);
            return "redirect:/";
        } else {
            model.addAttribute("message", "User already exists");
            return "customerRegistration";
        }
    }
}