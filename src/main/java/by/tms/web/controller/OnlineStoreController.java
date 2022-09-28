package by.tms.web.controller;


import by.tms.dto.ConvertDTOToObject;
import by.tms.dto.OfferDTO;
import by.tms.entity.*;
import by.tms.service.OfferService;
import by.tms.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    private ConvertDTOToObject convertDTOToObject;

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
    @GetMapping("/addElectronicBook")
    public String addingOffer(@ModelAttribute("newElectronicBook") ElectronicBook newElectronicBook) {
        return "addElectronicBook";
    }

    @PostMapping("/addElectronicBook")
    public String addingOffer(@Valid @ModelAttribute("newElectronicBook") ElectronicBook newElectronicBook, BindingResult bindingResult,
                              HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            return "addElectronicBook";
        }
        Store store = (Store) httpSession.getAttribute("currentUser");
        Offer offer = offerService.createOfferWithStoreAndProductCategory(store, newElectronicBook);
        httpSession.setAttribute("offer", offer);
        return "redirect:/store/createOffer";
    }
    @GetMapping("/addNotebook")
    public String addingOffer(@ModelAttribute("newNotebook") Notebook newNotebook) {
        return "addNotebook";
    }

    @PostMapping("/addNotebook")
    public String addingOffer(@Valid @ModelAttribute("newNotebook") Notebook newNotebook, BindingResult bindingResult,
                              HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            return "addNotebook";
        }
        Store store = (Store) httpSession.getAttribute("currentUser");
        Offer offer = offerService.createOfferWithStoreAndProductCategory(store, newNotebook);
        httpSession.setAttribute("offer", offer);
        return "redirect:/store/createOffer";
    }
    @GetMapping("/addSmartwatch")
    public String addingOffer(@ModelAttribute("newSmartwatch") Smartwatch newSmartwatch) {
        return "addSmartwatch";
    }

    @PostMapping("/addSmartwatch")
    public String addingOffer(@Valid @ModelAttribute("newSmartwatch") Smartwatch newSmartwatch, BindingResult bindingResult,
                              HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            return "addSmartwatch";
        }
        Store store = (Store) httpSession.getAttribute("currentUser");
        Offer offer = offerService.createOfferWithStoreAndProductCategory(store, newSmartwatch);
        httpSession.setAttribute("offer", offer);
        return "redirect:/store/createOffer";
    }
    @GetMapping("/addTablet")
    public String addingOffer(@ModelAttribute("newTablet") Tablet newTablet) {
        return "addTablet";
    }

    @PostMapping("/addTablet")
    public String addingOffer(@Valid @ModelAttribute("newTablet") Tablet newTablet, BindingResult bindingResult,
                              HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            return "addTablet";
        }
        Store store = (Store) httpSession.getAttribute("currentUser");
        Offer offer = offerService.createOfferWithStoreAndProductCategory(store, newTablet);
        httpSession.setAttribute("offer", offer);
        return "redirect:/store/createOffer";
    }
    @GetMapping("/createOffer")
    public String storeRegistration(@ModelAttribute("OfferDTO") OfferDTO offerDTO) {
        return "createOffer";
    }

    @PostMapping("/createOffer")
    public String registration(@Valid @ModelAttribute("OfferDTO") OfferDTO offerDTO, BindingResult bindingResult, HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            return "createOffer";
        }
        Offer offer = (Offer) httpSession.getAttribute("offer");
        offer = convertDTOToObject.convertOfferDTOtoOffer(offerDTO, offer);
        offerService.saveOffer(offer);
        httpSession.removeAttribute("offer");
        return "redirect:/";
    }
}
