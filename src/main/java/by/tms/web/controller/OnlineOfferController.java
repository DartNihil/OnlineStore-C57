package by.tms.web.controller;

import by.tms.dto.ConvertDTOToObject;
import by.tms.dto.OfferDTO;
import by.tms.entity.*;
import by.tms.service.OfferService;
import by.tms.service.ProductService;
import by.tms.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/offer")
public class OnlineOfferController {

    @Autowired
    private OfferService offerService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ConvertDTOToObject convertDTOToObject;

    @GetMapping("/selectProductCategory")
    public String selectProductCategory() {
        return "selectProductCategory";
    }

    @PostMapping("/selectProductCategory")
    public String selectProductCategory(String productCategory, Model model) {
        List<Product> productList = productService.getProductListForStoreOffer(productCategory);
        model.addAttribute("productList", productList);
        return "selectProduct";
    }

    @GetMapping("/addProduct")
    public String addProduct(String productCategory, Model model) {
        if (productCategory.equals("Smartphone")) {
            Smartphone smartphone = new Smartphone();
            model.addAttribute("newSmartphone", smartphone);
        }
        return "selectProduct";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute("newSmartphone") Smartphone newSmartphone, HttpSession httpSession) {
        newSmartphone.setColor("black");
        Store store = (Store) httpSession.getAttribute("currentUser");
        Offer offer = offerService.createOfferWithStoreAndProductCategory(store, newSmartphone);
        System.out.println(offer);
        httpSession.setAttribute("offer", offer);
        return "redirect:/offer/createOffer";
    }

//    @GetMapping("/addSmartphone")
//    public String addingOffer(@ModelAttribute("newSmartphone") Smartphone newSmartphone) {
//        return "addSmartphone";
//    }
//
//    @PostMapping("/addSmartphone")
//    public String addingOffer(@Valid @ModelAttribute("newSmartphone") Smartphone newSmartphone, BindingResult bindingResult,
//                              HttpSession httpSession, String productCategory) {
//
//        if (bindingResult.hasErrors()) {
//            return "addSmartphone";
//        }
//        Store store = (Store) httpSession.getAttribute("currentUser");
//        Offer offer = offerService.createOfferWithStoreAndProductCategory(store, newSmartphone);
//        httpSession.setAttribute("offer", offer);
//        return "redirect:/offer/createOffer";
//    }
//
//    @GetMapping("/addElectronicBook")
//    public String addingOffer(@ModelAttribute("newElectronicBook") ElectronicBook newElectronicBook) {
//        return "addElectronicBook";
//    }
//
//    @PostMapping("/addElectronicBook")
//    public String addingOffer(@Valid @ModelAttribute("newElectronicBook") ElectronicBook newElectronicBook, BindingResult bindingResult,
//                              HttpSession httpSession) {
//        if (bindingResult.hasErrors()) {
//            return "addElectronicBook";
//        }
//        Store store = (Store) httpSession.getAttribute("currentUser");
//        Offer offer = offerService.createOfferWithStoreAndProductCategory(store, newElectronicBook);
//        httpSession.setAttribute("offer", offer);
//        return "redirect:/offer/createOffer";
//    }
//
//    @GetMapping("/addNotebook")
//    public String addingOffer(@ModelAttribute("newNotebook") Notebook newNotebook) {
//        return "addNotebook";
//    }
//
//    @PostMapping("/addNotebook")
//    public String addingOffer(@Valid @ModelAttribute("newNotebook") Notebook newNotebook, BindingResult bindingResult,
//                              HttpSession httpSession) {
//        if (bindingResult.hasErrors()) {
//            return "addNotebook";
//        }
//        Store store = (Store) httpSession.getAttribute("currentUser");
//        Offer offer = offerService.createOfferWithStoreAndProductCategory(store, newNotebook);
//        httpSession.setAttribute("offer", offer);
//        return "redirect:/offer/createOffer";
//    }
//
//    @GetMapping("/addSmartwatch")
//    public String addingOffer(@ModelAttribute("newSmartwatch") Smartwatch newSmartwatch) {
//        return "addSmartwatch";
//    }
//
//    @PostMapping("/addSmartwatch")
//    public String addingOffer(@Valid @ModelAttribute("newSmartwatch") Smartwatch newSmartwatch, BindingResult bindingResult,
//                              HttpSession httpSession) {
//        if (bindingResult.hasErrors()) {
//            return "addSmartwatch";
//        }
//        Store store = (Store) httpSession.getAttribute("currentUser");
//        Offer offer = offerService.createOfferWithStoreAndProductCategory(store, newSmartwatch);
//        httpSession.setAttribute("offer", offer);
//        return "redirect:/offer/createOffer";
//    }
//
//    @GetMapping("/addTablet")
//    public String addingOffer(@ModelAttribute("newTablet") Tablet newTablet) {
//        return "addTablet";
//    }
//
//    @PostMapping("/addTablet")
//    public String addingOffer(@Valid @ModelAttribute("newTablet") Tablet newTablet, BindingResult bindingResult,
//                              HttpSession httpSession) {
//        if (bindingResult.hasErrors()) {
//            return "addTablet";
//        }
//        Store store = (Store) httpSession.getAttribute("currentUser");
//        Offer offer = offerService.createOfferWithStoreAndProductCategory(store, newTablet);
//        httpSession.setAttribute("offer", offer);
//        return "redirect:/offer/createOffer";
//    }

    @GetMapping("/createOffer")
    public String createOffer(@ModelAttribute("OfferDTO") OfferDTO offerDTO) {
        return "createOffer";
    }

    @PostMapping("/createOffer")
    public String createOffer(@Valid @ModelAttribute("OfferDTO") OfferDTO offerDTO, BindingResult bindingResult, HttpSession httpSession) {
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
