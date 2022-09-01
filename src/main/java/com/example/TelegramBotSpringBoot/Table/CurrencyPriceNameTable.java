package com.example.TelegramBotSpringBoot.Table;

import javax.persistence.*;

@Entity
@Table(name="currency_price_name")
public class CurrencyPriceNameTable {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String currencyName;
    private Double price;

    public CurrencyPriceNameTable() {
    }

    public CurrencyPriceNameTable(String currencyName, Double price) {
        this.currencyName = currencyName;
        this.price = price;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
