package by.tms.entity;

import by.tms.dto.OfferWithCountDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class Customer extends User {

    @NotBlank(message = "Field must not be empty")
    @Size(message = "Nickname length must be 2 - 16", min = 2, max = 16)
    private String nickname;

    @NotBlank(message = "Field must not be empty")
    @Size(message = "Firstname length must be 2 - 16", min = 2, max = 16)
    private String firstname;

    @NotBlank(message = "Field must not be empty")
    @Size(message = "Lastname length must be 2 - 16", min = 2, max = 16)
    private String lastname;


    private final List<OfferWithCountDto> cart = new ArrayList<>();
    private final List<OfferWithCountDto> completedOrder = new ArrayList<>();

    @NotBlank(message = "Field must not be empty")
    @Size(message = "Phone number has incorrect length!", min = 13, max = 13)
    @Pattern(message = "Phone number is incorrect!", regexp = "\\+375[\\d]+")
    private int phoneNumber;
    private final List<OfferComposite> cart = new ArrayList<>();


    public Customer() {
    }

    public Customer(long id, String email, String password, String nickname, String firstname, String lastname, int phoneNumber) {
        super(id, email, password);
        this.nickname = nickname;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<OfferWithCountDto> getCart() {
        return cart;
    }

    public List<OfferWithCountDto> getCompletedOrder() {
        return completedOrder;
    }

    public int getCountOffersInCart() {
        int count = 0;
        for (int i = 0; i < cart.size(); i++) {
            count = count + cart.get(i).getCount();
        }
        return count;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "nickname='" + nickname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + this.getEmail() + '\'' +
                ", password='" + this.getPassword() + '\'' +
                ", id='" + this.getId() + '\'' +
                '}';
    }
}
