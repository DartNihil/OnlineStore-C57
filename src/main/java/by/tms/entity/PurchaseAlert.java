package by.tms.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PurchaseAlert {
    LocalDateTime dateTime;
    User user;
    Offer offer;

    public PurchaseAlert() {
    }

    public PurchaseAlert(User user, Offer offer) {
        this.dateTime = LocalDateTime.now();
        this.user = user;
        this.offer = offer;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public String getFormatDateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm\ndd.MM.yyyy");
        return dtf.format(dateTime);
    }

    @Override
    public String toString() {
        return "PurchaseAlert{" +
                "dateTime=" + dateTime +
                ", user=" + user +
                ", offer=" + offer +
                '}';
    }
}
