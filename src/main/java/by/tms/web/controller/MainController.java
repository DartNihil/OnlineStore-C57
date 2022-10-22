package by.tms.web.controller;

import by.tms.entity.User;
import by.tms.service.CustomerService;
import by.tms.service.OfferService;
import by.tms.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
    private final StoreService storeService;

    private final CustomerService customerService;

    private final OfferService offerService;


    @Autowired
    public MainController(StoreService storeService, CustomerService customerService, OfferService offerService) {
        this.storeService = storeService;
        this.customerService = customerService;
        this.offerService = offerService;
    }

    @PostMapping
    public String homepageSearch(String searchProduct, Model model) {
        return "redirect: /search";
    }

    @GetMapping("/login")
    public String login(@ModelAttribute("user") User user) {
        return "login";
    }

    @GetMapping("/catalog/mobile")
    public String mobile(Model model){
        model.addAttribute("phones", offerService.getSmartphoneList());
        return "catalog/catalogMobile";
    }

    @GetMapping("/catalog/tablet")
    public String tabletPC(Model model){
        model.addAttribute("tablets", offerService.getTabletList());
        return "catalog/catalogTabletpc";
    }

    @GetMapping("/catalog/ebook")
    public String ebook(Model model){
        model.addAttribute("ebooks", offerService.getElectronicBookList());
        ;            return "catalog/catalogEbook";
    }

    @GetMapping("/catalog/smartwatch")
    public String smartwatch(Model model){
        model.addAttribute("smartwatchs", offerService.getSmartwatchList());
        return "catalog/catalogSmatwatch";
    }

    @GetMapping("/catalog/notebook")
    public String notebook(Model model){
        model.addAttribute("notebooks", offerService.getNotebookList());
        return "catalog/catalogNotebook";
    }

}