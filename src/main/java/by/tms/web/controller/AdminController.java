package by.tms.web.controller;

import by.tms.entity.*;
import by.tms.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    ProductService productService;

    @GetMapping("/selectProductCategory")
    public String selectProductCategory() {
        return "admin/selectProductCategoryByAdmin";
    }

    @PostMapping("/selectProductCategory")
    public String selectProductCategory(String productCategory) {

        return productService.getPageNameForProductToAdmin(productCategory);
    }

    @GetMapping("/addSmartphone")
    public String addSmartphone(@ModelAttribute("newSmartphone") Smartphone newSmartphone) {
        return "admin/addSmartphoneByAdmin";
    }

    @PostMapping("/addSmartphone")
    public String addSmartphone(@Valid @ModelAttribute("newSmartphone") Smartphone newSmartphone, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/addSmartphoneByAdmin";
        }
        productService.saveProduct(newSmartphone);
        return "redirect:/";
    }

    @GetMapping("/addElectronicBook")
    public String addElectronicBook(@ModelAttribute("newElectronicBook") ElectronicBook newElectronicBook) {
        return "admin/addElectronicBookByAdmin";
    }

    @PostMapping("/addElectronicBook")
    public String addElectronicBook(@Valid @ModelAttribute("newElectronicBook") ElectronicBook newElectronicBook, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/addElectronicBookByAdmin";
        }
        productService.saveProduct(newElectronicBook);
        return "redirect:/";
    }

    @GetMapping("/addNotebook")
    public String addNotebook(@ModelAttribute("newNotebook") Notebook newNotebook) {
        return "admin/addNotebookByAdmin";
    }

    @PostMapping("/addNotebook")
    public String addNotebook(@Valid @ModelAttribute("newNotebook") Notebook newNotebook, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/addNotebookByAdmin";
        }
        productService.saveProduct(newNotebook);
        return "redirect:/";
    }

    @GetMapping("/addSmartwatch")
    public String addSmartwatch(@ModelAttribute("newSmartwatch") Smartwatch newSmartwatch) {
        return "admin/addSmartwatchByAdmin";
    }

    @PostMapping("/addSmartwatch")
    public String addSmartwatch(@Valid @ModelAttribute("newSmartwatch") Smartwatch newSmartwatch, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/addSmartwatchByAdmin";
        }
        productService.saveProduct(newSmartwatch);
        return "redirect:/";
    }

    @GetMapping("/addTablet")
    public String addTablet(@ModelAttribute("newTablet") Tablet newTablet) {
        return "admin/addTabletByAdmin";
    }

    @PostMapping("/addTablet")
    public String addTablet(@Valid @ModelAttribute("newTablet") Tablet newTablet, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/addTabletByAdmin";
        }
        productService.saveProduct(newTablet);
        return "redirect:/";
    }
}
