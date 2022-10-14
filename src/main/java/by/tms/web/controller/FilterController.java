package by.tms.web.controller;


import by.tms.entity.AbstractProduct;
import by.tms.entity.Filter;
import by.tms.entity.Smartphone;
import by.tms.service.SearchProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/filter")
public class FilterController {

    SearchProductService searchProductService;

    @Autowired
    public FilterController(SearchProductService searchProductService) {
        this.searchProductService = searchProductService;
    }

    @GetMapping("/filter")
    public String filter(@ModelAttribute("newFilter")Filter filter) {
        List<AbstractProduct> byFilter = searchProductService.findByFilter(filter);
        return "filter";
    }
}
