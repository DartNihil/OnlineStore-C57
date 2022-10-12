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

    private final CustomerService customerService;

    private final StoreService storeService;

    @Autowired
    public OnlineCustomerController(CustomerService customerService, StoreService storeService) {
        this.customerService = customerService;
        this.storeService = storeService;
    }

    @GetMapping("/customerRegistration")
    public String CustomerRegistration(@ModelAttribute("newCustomer") Customer customer) {
        return "customer/customerRegistration";
    }
    @GetMapping("/personalData")
    public String CustomerPersonalData(@ModelAttribute("currentCustomer") Customer customer) {
        return "customer/customerPersonalData";
    }
    @GetMapping("/change/fullName")
    public String customerChangeOfFullName(@ModelAttribute("currentCustomer") Customer customer) {
        return "customer/customerChangeOfFullName";
    }
    @GetMapping("/change/nickName")
    public String customerChangeOfNickName(@ModelAttribute("currentCustomer") Customer customer) {
        return "customer/customerChangeOfNickName";
    }
    @GetMapping("/change/phoneNumber")
    public String customerChangeOfPhoneNumber(@ModelAttribute("currentCustomer") Customer customer) {
        return "customer/customerChangeOfPhoneNumber";
    }

    @PostMapping("/customerRegistration")
    public String registration(@Valid @ModelAttribute("newCustomer") Customer customer, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "customer/customerRegistration";
        }
        if (customerService.findCustomerByEmail(customer.getEmail()).isEmpty()
                && storeService.findStoreByEmail(customer.getEmail()).isEmpty()) {
            customerService.saveCustomer(customer);
            return "redirect:/";
        } else {
            model.addAttribute("message", "User already exists");
            return "customer/customerRegistration";
        }
    }
    @PostMapping("/change/fullName")
    public String changeFullName(@Valid @ModelAttribute("currentCustomer") Customer customer, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "customer/customerChangeOfFullName";
        } else {
            customer.setFirstname((String) model.getAttribute("firstname"));
            customer.setLastname((String) model.getAttribute("lastname"));
            customerService.saveCustomer(customer);
            return "customer/customerPersonalData";
        }
    }
    @PostMapping("/change/nickName")
    public String changeNickName(@Valid @ModelAttribute("currentCustomer") Customer customer, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "customer/customerChangeOfNickName";
        } else {
            customer.setNickname((String) model.getAttribute("nickname"));
            customerService.saveCustomer(customer);
            return "customer/customerPersonalData";
        }
    }
    @PostMapping("/change/phoneNumber")
    public String changePhoneNumber(@Valid @ModelAttribute("currentCustomer") Customer customer, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "customer/customerChangeOfPhoneNumber";
        } else {
            customer.setTelephone((int)model.getAttribute("telephone"));
            customerService.saveCustomer(customer);
            return "customer/customerPersonalData";
        }
    }
}
