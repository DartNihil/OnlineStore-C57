package by.tms.web.controller;

import by.tms.composite.OfferComposite;
import by.tms.entity.Customer;
import by.tms.service.CustomerService;
import by.tms.service.OfferService;
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
import java.util.List;

@Controller
@RequestMapping("/customer")
public class OnlineCustomerController {
    private final CustomerService customerService;
    private final StoreService storeService;
    private final OfferService offerService;

    public OnlineCustomerController(CustomerService customerService, StoreService storeService, OfferService offerService) {
        this.customerService = customerService;
        this.storeService = storeService;
        this.offerService = offerService;
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
    @GetMapping("/cart")
    public String cart() {
        return "cartPage";
    }

    @PostMapping("/cart")
    public String cart(Model model, HttpSession httpSession) {
        Customer currentUser = (Customer) httpSession.getAttribute("currentUser");
        List<OfferComposite> cart = currentUser.getCart();
        model.addAttribute("cartList", cart);
        model.addAttribute("totalPrice", offerService.findTotalPriceOffersInCart(cart));
        return "cartPage";
    }
}