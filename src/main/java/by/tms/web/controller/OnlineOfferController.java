package by.tms.web.controller;

import by.tms.composite.OfferComposite;
import by.tms.dto.ConvertDTOToObject;
import by.tms.dto.OfferDTO;
import by.tms.entity.*;
import by.tms.service.OfferService;
import by.tms.service.ProductService;
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
import java.util.Optional;

@Controller
@RequestMapping("/offer")
public class OnlineOfferController {
    private final OfferService offerService;
    private final ProductService productService;
    private final ConvertDTOToObject convertDTOToObject;

    public OnlineOfferController(OfferService offerService, ProductService productService, ConvertDTOToObject convertDTOToObject) {
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
        List<Product> productList = productService.getProductListForStoreOffer(productCategory);
        model.addAttribute("productList", productList);
        return productService.getPageNameForProduct(productCategory);
    }

    @GetMapping("/addSmartphone")
    public String addSmartphone() {
        return "storeOffer/selectSmartphone";
    }

    @PostMapping("/addSmartphone")
    public String addSmartphone(Long id, Smartphone newSmartphone, HttpSession httpSession) {
        Optional<Product> smartphoneInBase = productService.findProductById(id);
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
        Optional<Product> electronicBookInBase = productService.findProductById(id);
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
        Optional<Product> notebookInBase = productService.findProductById(id);
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
        Optional<Product> smartwatchInBase = productService.findProductById(id);
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
        Optional<Product> tabletInBase = productService.findProductById(id);
        if (tabletInBase.isPresent()) {
            newTablet = (Tablet) tabletInBase.get();
        }
        Store store = (Store) httpSession.getAttribute("currentUser");
        Offer offer = offerService.createOfferWithStoreAndProductCategory(store, newTablet);
        httpSession.setAttribute("offer", offer);
        return "redirect:/offer/createOffer";
    }

    @GetMapping("/createOffer")
    public String createOffer(@ModelAttribute("OfferDTO") OfferDTO offerDTO) {
        return "storeOffer/createOffer";
    }

    @PostMapping("/createOffer")
    public String createOffer(@Valid @ModelAttribute("OfferDTO") OfferDTO offerDTO, BindingResult bindingResult, HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            return "storeOffer/createOffer";
        }
        Offer offer = (Offer) httpSession.getAttribute("offer");
        offer = convertDTOToObject.convertOfferDTOtoOffer(offerDTO, offer);
        offerService.saveOffer(offer);
        httpSession.removeAttribute("offer");
        return "redirect:/";
    }
    @GetMapping("/addOfferToCart")
    public String addOfferToCart() {
        return "cartPage";
    }

    @PostMapping("/addOfferToCart")
    public String addOfferToCart(long offerId, HttpSession httpSession, Model model) {
        Customer currentUser = (Customer) httpSession.getAttribute("currentUser");
        List<OfferComposite> cart = offerService.addOfferToCart(offerId, currentUser);
        model.addAttribute("cartList", cart);
        model.addAttribute("totalPrice", offerService.findTotalPriceOffersInCart(cart));
        return "cartPage";
    }

    @GetMapping("/checkout")
    public String checkout() {
        return "checkoutPage";
    }

    @PostMapping("/checkout")
    public String checkout(long offerId, Model model) {
        Optional<Offer> offerById = offerService.findOfferById(offerId);
        model.addAttribute("offerToCheckout", offerById.get());
        return "checkoutPage";
    }

    @GetMapping("/deleteFromCart")
    public String deleteFromCart() {
        return "cartPage";
    }

    @PostMapping("/deleteFromCart")
    public String deleteFromCart(long offerId, HttpSession httpSession, Model model) {
        Customer currentUser = (Customer) httpSession.getAttribute("currentUser");
        List<OfferComposite> cart = offerService.deleteOfferFromCart(offerId, currentUser);
        model.addAttribute("cartList", cart);
        model.addAttribute("totalPrice", offerService.findTotalPriceOffersInCart(cart));
        return "cartPage";
    }

    @GetMapping("/minusOffer")
    public String minusOffer() {
        return "cartPage";
    }

    @PostMapping("/minusOffer")
    public String minusOffer(long offerId, HttpSession httpSession, Model model) {
        Customer currentUser = (Customer) httpSession.getAttribute("currentUser");
        List<OfferComposite> cart = offerService.minusOfferCount(offerId, currentUser);
        model.addAttribute("cartList", cart);
        model.addAttribute("totalPrice", offerService.findTotalPriceOffersInCart(cart));
        return "cartPage";
    }

    @GetMapping("/plusOffer")
    public String plusOffer() {
        return "cartPage";
    }

    @PostMapping("/plusOffer")
    public String plusOffer(long offerId, HttpSession httpSession, Model model) {
        Customer currentUser = (Customer) httpSession.getAttribute("currentUser");
        List<OfferComposite> cart = offerService.plusOfferCount(offerId, currentUser);
        model.addAttribute("cartList", cart);
        model.addAttribute("totalPrice", offerService.findTotalPriceOffersInCart(cart));
        return "cartPage";
    }

}
