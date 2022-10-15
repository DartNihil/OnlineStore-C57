package by.tms.web.controller;

import by.tms.entity.User;
import by.tms.service.CustomerService;
import by.tms.service.ProductService;
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

    private final ProductService productService;


    @Autowired
    public MainController(StoreService storeService, CustomerService customerService, ProductService productService) {
        this.storeService = storeService;
        this.customerService = customerService;
        this.productService = productService;
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
        model.addAttribute("phone", productService.getSmartphoneList());
        return "catalogMobile";
    }

    @GetMapping("/catalog/tablet")
    public String tabletPC(Model model){
        model.addAttribute("tablet", productService.getTabletList());
        return "catalogTabletpc";
    }

    @GetMapping("/catalog/ebook")
    public String ebook(Model model){
        model.addAttribute("ebook", productService.getElectronicBookList());
        ;            return "catalogEbook";
    }

    @GetMapping("/catalog/smartwatch")
    public String smartwatch(Model model){
        model.addAttribute("smartwatch", productService.getSmartwatchList());
        return "catalogSmatwatch";
    }

    @GetMapping("/catalog/notebook")
    public String notebook(Model model){
        model.addAttribute("notebook", productService.getNotebookList());
        return "catalogNotebook";
    }

}