package by.tms.web.controller;

import by.tms.entity.Customer;
import by.tms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

        @GetMapping("/customerRegistration")
        public String CustomerRegistration(@ModelAttribute("newCustomer") Customer customer) {
            return "customerRegistration";
        }

        @PostMapping("/customerRegistration")
        public String registration(@Valid @ModelAttribute("newCustomer") Customer customer, BindingResult bindingResult) {
            if (bindingResult.hasErrors()) {
                return "customerRegistration";
            }
            customerService.saveCustomer(customer);
            return "redirect:/";
        }
    }
