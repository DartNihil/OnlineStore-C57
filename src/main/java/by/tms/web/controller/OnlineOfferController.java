package by.tms.web.controller;

import by.tms.dto.ConvertDtoToObject;
import by.tms.dto.MapStoreProfileEditDtoToStore;
import by.tms.dto.OfferDto;
import by.tms.dto.StoreProfileEditDto;
import by.tms.entity.*;
import by.tms.service.OfferService;
import by.tms.service.ProductService;
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
import java.util.Optional;

@Controller
@RequestMapping("/offer")
public class OnlineOfferController {

    private final OfferService offerService;
    private final ProductService productService;
    private final ConvertDtoToObject convertDTOToObject;

    public OnlineOfferController(OfferService offerService, ProductService productService, ConvertDtoToObject convertDTOToObject) {
        this.offerService = offerService;
        this.productService = productService;
        this.convertDTOToObject = convertDTOToObject;
    }

    @GetMapping("/selectProductCategory")
    public String selectProductCategory() {
        return "storeOffer/selectProductCategory";
    }

    @PostMapping("/selectProductCategory")
    public String selectProductCategory(String productCategory, Model model) {
        List<AbstractProduct> productList = productService.getProductListForStoreOffer(productCategory);
        model.addAttribute("productList", productList);
        return productService.getPageNameForProduct(productCategory);
    }

    @GetMapping("/addSmartphone")
    public String addSmartphone() {
        return "storeOffer/selectSmartphone";
    }

    @PostMapping("/addSmartphone")
    public String addSmartphone(Long id, Smartphone newSmartphone, HttpSession httpSession) {
        Optional<AbstractProduct> smartphoneInBase = productService.findProductById(id);
        if (smartphoneInBase.isPresent()) {
            newSmartphone = (Smartphone) smartphoneInBase.get();
        }
        Store store = (Store) httpSession.getAttribute("currentUser");
        Offer offer = offerService.createOfferWithStoreAndProductCategory(store, newSmartphone);
        httpSession.setAttribute("offer", offer);
        return "redirect:/offer/createOffer";
    }

    @GetMapping("/addElectronicBook")
    public String addElectronicBook() {
        return "storeOffer/selectElectronicBook";
    }

    @PostMapping("/addElectronicBook")
    public String addElectronicBook(Long id, ElectronicBook newElectronicBook, HttpSession httpSession) {
        Optional<AbstractProduct> electronicBookInBase = productService.findProductById(id);
        if (electronicBookInBase.isPresent()) {
            newElectronicBook = (ElectronicBook) electronicBookInBase.get();
        }
        Store store = (Store) httpSession.getAttribute("currentUser");
        Offer offer = offerService.createOfferWithStoreAndProductCategory(store, newElectronicBook);
        httpSession.setAttribute("offer", offer);
        return "redirect:/offer/createOffer";
    }

    @GetMapping("/addNotebook")
    public String addNotebook() {
        return "storeOffer/selectNotebook";
    }

    @PostMapping("/addNotebook")
    public String addNotebook(Long id, Notebook newNotebook, HttpSession httpSession) {
        Optional<AbstractProduct> notebookInBase = productService.findProductById(id);
        if (notebookInBase.isPresent()) {
            newNotebook = (Notebook) notebookInBase.get();
        }
        Store store = (Store) httpSession.getAttribute("currentUser");
        Offer offer = offerService.createOfferWithStoreAndProductCategory(store, newNotebook);
        httpSession.setAttribute("offer", offer);
        return "redirect:/offer/createOffer";
    }

    @GetMapping("/addSmartwatch")
    public String addSmartwatch() {
        return "storeOffer/selectSmartwatch";
    }

    @PostMapping("/addSmartwatch")
    public String addSmartwatch(Long id, Smartwatch newSmartwatch, HttpSession httpSession) {
        Optional<AbstractProduct> smartwatchInBase = productService.findProductById(id);
        if (smartwatchInBase.isPresent()) {
            newSmartwatch = (Smartwatch) smartwatchInBase.get();
        }
        Store store = (Store) httpSession.getAttribute("currentUser");
        Offer offer = offerService.createOfferWithStoreAndProductCategory(store, newSmartwatch);
        httpSession.setAttribute("offer", offer);
        return "redirect:/offer/createOffer";
    }

    @GetMapping("/addTablet")
    public String addTablet() {
        return "storeOffer/selectTablet";
    }

    @PostMapping("/addTablet")
    public String addTablet(Long id, Tablet newTablet, HttpSession httpSession) {
        Optional<AbstractProduct> tabletInBase = productService.findProductById(id);
        if (tabletInBase.isPresent()) {
            newTablet = (Tablet) tabletInBase.get();
        }
        Store store = (Store) httpSession.getAttribute("currentUser");
        Offer offer = offerService.createOfferWithStoreAndProductCategory(store, newTablet);
        httpSession.setAttribute("offer", offer);
        return "redirect:/offer/createOffer";
    }

    @GetMapping("/createOffer")
    public String createOffer(@ModelAttribute("OfferDTO") OfferDto offerDTO) {
        return "storeOffer/createOffer";
    }

    @PostMapping("/createOffer")
    public String createOffer(@Valid @ModelAttribute("OfferDTO") OfferDto offerDTO, BindingResult bindingResult, HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            return "storeOffer/createOffer";
        }
        Offer offer = (Offer) httpSession.getAttribute("offer");
        offer = convertDTOToObject.convertOfferDTOtoOffer(offerDTO, offer);
        offerService.saveOffer(offer);
        httpSession.removeAttribute("offer");
        return "redirect:/";
    }
    @GetMapping("/deleteOffer")
    public String deleteOffer(HttpServletRequest req , Model model , HttpSession session) {
        Long id = Long.valueOf((req.getParameter("id")));
        offerService.deleteOffer(offerService.findOfferById(id).get());
        model.addAttribute("listOfOffers" , offerService.findOffersByStore((Store) session.getAttribute("currentUser")));
        return "redirect:/store/storeProfile";
    }
    @GetMapping("/editOffer")
    public String editOffer(@ModelAttribute("editedOffer") StoreProfileEditDto storeProfileEditDto){
        return "editOffer";
    }
    @PostMapping("/editOffer")
    public String editOffer(@Valid @ModelAttribute("editedOffer") StoreProfileEditDto storeProfileEditDto , BindingResult bindingResult, HttpSession session , Model model , HttpServletRequest req){
        if(bindingResult.hasErrors()){
            return "editOffer";
        }
        Long id = Long.valueOf(req.getParameter("id"));
        Offer offer = offerService.findOfferById(id).get();
        Offer newOffer = convertDTOToObject.convertOfferEditDTOToOffer(storeProfileEditDto , offer);
        model.addAttribute("listOfOffers" , offerService.findOffersByStore((Store) session.getAttribute("currentUser")));
        return "redirect:/store/storeProfile";
    }
}
