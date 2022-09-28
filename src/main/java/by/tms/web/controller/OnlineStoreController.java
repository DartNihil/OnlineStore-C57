package by.tms.web.controller;


import by.tms.entity.Offer;
import by.tms.entity.Smartphone;
import by.tms.entity.Store;
import by.tms.service.OfferService;
import by.tms.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/store")
public class OnlineStoreController {
    @Autowired
    private StoreService storeService;
    @Autowired
    private OfferService offerService;

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
    @GetMapping("/addSmartphone")
    public String addingOffer(@ModelAttribute("newSmartphone") Smartphone newSmartphone) {
        return "addSmartphone";
    }

    @PostMapping("/addSmartphone")
    public String addingOffer(@Valid @ModelAttribute("newSmartphone") Smartphone newSmartphone, BindingResult bindingResult, HttpSession httpSession) {
        Store store = (Store) httpSession.getAttribute("currentUser");
        Offer newOffer = new Offer();
        newOffer = offerService.createOfferWithStoreAndProductCategory(newOffer, store, "Smartphone");
        if (bindingResult.hasErrors()) {
            return "addingOffer";
        }
        newOffer.setProduct(newSmartphone);
        System.out.println(newOffer);
        return "redirect:/";
    }
}
