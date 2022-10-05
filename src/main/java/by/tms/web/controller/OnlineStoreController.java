package by.tms.web.controller;


import by.tms.dto.ConvertDTOToObject;
import by.tms.dto.OfferDTO;
import by.tms.entity.*;
import by.tms.service.OfferService;
import by.tms.service.ProductService;
import by.tms.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.net.http.HttpRequest;

@Controller
@RequestMapping("/store")
public class OnlineStoreController {
    @Autowired
    private StoreService storeService;

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
}
