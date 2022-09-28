package by.tms.web.controller;


import by.tms.dto.ConvertDTOtoObject;
import by.tms.dto.OfferDTO;
import by.tms.entity.Offer;
import by.tms.entity.Smartphone;
import by.tms.entity.Store;
import by.tms.service.OfferService;
import by.tms.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/store")
public class OnlineStoreController {
    @Autowired
    private StoreService storeService;
    @Autowired
    private OfferService offerService;
    @Autowired
    private ConvertDTOtoObject convertDTOtoObject;

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
    public String addingOffer(@Valid @ModelAttribute("newSmartphone") Smartphone newSmartphone, BindingResult bindingResult,
                               HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            return "addSmartphone";
        }
        Store store = (Store) httpSession.getAttribute("currentUser");
        Offer offer = offerService.createOfferWithStoreAndProductCategory(store, newSmartphone);
        httpSession.setAttribute("offer", offer);
        return "redirect:/store/createOffer";
    }
    @GetMapping("/createOffer")
    public String storeRegistration(@ModelAttribute("OfferDTO") OfferDTO offerDTO) {
        return "createOffer";
    }

    @PostMapping("/createOffer")
    public String registration(@Valid @ModelAttribute("OfferDTO") OfferDTO offerDTO, BindingResult bindingResult, HttpSession httpSession) {
        Offer offer = (Offer) httpSession.getAttribute("offer");
        if (bindingResult.hasErrors()) {
            return "createOffer";
        }
        offer = convertDTOtoObject.convertOfferDTOtoOffer(offerDTO, offer);
        offerService.saveOffer(offer);
        httpSession.removeAttribute("offer");
        return "redirect:/";
    }
}
