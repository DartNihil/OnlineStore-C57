package by.tms.web.controller;

import by.tms.Properties;
import by.tms.storage.JdbcCustomerStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private final JdbcCustomerStorage jdbcCustomerStorage;

    public CustomerController(JdbcCustomerStorage jdbcCustomerStorage) {
        this.jdbcCustomerStorage = jdbcCustomerStorage;
    }


    @GetMapping("/index1")
    public String index(Model model) {
       // model.addAttribute("customers", jdbcCustomerStorage.index1());
        model.addAttribute("customers", jdbcCustomerStorage.getListOfEntity());
        return "index1";
    }

    @GetMapping("/show/{id}")
    public String show(@PathVariable("id") long id, Model model) {
        //model.addAttribute("person", jdbcCustomerStorage.show(id));
        model.addAttribute("person", jdbcCustomerStorage.findById(id));
        return "show";
    }


}
