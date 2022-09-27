package by.tms.configuration;

import by.tms.entity.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

    @Configuration
    @EnableWebMvc
    @ComponentScan(basePackages = "by.tms")
    public class WebConfiguration{
        @Bean
        @Lazy
        public AtomicLong customerIdGenerator(){
            return new AtomicLong(0);
        }
        @Bean
        @Lazy
        public List<Customer> customerList(){
            return new ArrayList<Customer>();
        }

        @Bean
        public ViewResolver viewResolver(){
            InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
            internalResourceViewResolver.setSuffix(".jsp");
            internalResourceViewResolver.setPrefix("/pages/");
            return internalResourceViewResolver;
        }
    }

