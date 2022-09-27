package by.tms.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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

    public Customer() {}

    public Customer(String nickname, String firstname, String lastname) {
        this.nickname = nickname;
        this.firstname = firstname;
        this.lastname = lastname;
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

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "nickname='" + nickname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                '}';
    }
}
