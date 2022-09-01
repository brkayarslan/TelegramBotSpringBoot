package com.example.TelegramBotSpringBoot.Table;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CurrencyPriceNameController {

    @Autowired
    private CurrencyPriceNameTableRepository currencyPriceNameTableRepository;

    @GetMapping("/currency_price_name_table")
    public String listAll(Model model){
        List<CurrencyPriceNameTable> currencyPriceNameTableList =  currencyPriceNameTableRepository.findAll();
        model.addAttribute("currencyPriceNameTableList",currencyPriceNameTableList);
        return "currency_price_name_table";
    }
}
