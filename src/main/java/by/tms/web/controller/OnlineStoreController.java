package by.tms.web.controller;

import by.tms.dto.MapStoreProfileEditDtoToStore;
import by.tms.dto.StoreProfileEditDto;
import by.tms.entity.Customer;
import by.tms.entity.Store;
import by.tms.service.CustomerService;
import by.tms.service.OfferService;
import by.tms.service.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/store")
public class OnlineStoreController {
    private final StoreService storeService;
    private final CustomerService customerService;
    private final OfferService offerService;
    private final MapStoreProfileEditDtoToStore mapStoreProfileEditDtoToStore;

    public OnlineStoreController(StoreService storeService, CustomerService customerService, OfferService offerService, MapStoreProfileEditDtoToStore mapStoreProfileEditDtoToStore) {
        this.storeService = storeService;
        this.customerService = customerService;
        this.offerService = offerService;
        this.mapStoreProfileEditDtoToStore = mapStoreProfileEditDtoToStore;
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
    @GetMapping("/storeProfile")
    public String storeProfile(HttpSession session, Model model) {
        if (session.getAttribute("currentUser") instanceof Customer) {
            return "redirect:/"; //should return "customer/customerProfile"
        } else if (session.getAttribute("currentUser") instanceof Store) {
            model.addAttribute("listOfOffers" , offerService.findOffersByStore((Store) session.getAttribute("currentUser")));
            return "storeProfile";
        }
        return "redirect:/login";
    }

    @PostMapping("/storeProfile")
    public String storeProfile() {
        return "storeProfile";
    }
    @GetMapping("/storeProfileEdit")
    public String storeProfileEdit(@ModelAttribute("editedStore") StoreProfileEditDto storeProfileEditDTO){
        return "storeProfileEdit";
    }
    @PostMapping("/storeProfileEdit")
    public String storeProfileEdit(@Valid @ModelAttribute("editedStore") StoreProfileEditDto storeProfileEditDTO , BindingResult bindingResult , HttpSession session){
        if(bindingResult.hasErrors()){
            return "storeProfileEdit";
        }
        Store newStore = mapStoreProfileEditDtoToStore.convertStoreProfileEditDTOToStore(storeProfileEditDTO ,
                (Store) session.getAttribute("currentUser"));
        session.setAttribute("currentUser" , newStore);
        return "storeProfile";
    }
}
