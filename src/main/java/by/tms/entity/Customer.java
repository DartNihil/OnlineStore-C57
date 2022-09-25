package by.tms.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Customer extends User {
    @NotBlank(message = "Field must not ne empty")
    @Size(min = 2 , max = 20 , message = "Available name length: 2-20 characters")
    private String name;

    public Customer(String name , String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
