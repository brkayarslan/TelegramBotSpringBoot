package com.example.TelegramBotSpringBoot.service;

import com.example.TelegramBotSpringBoot.model.PairCurrenciesResponsModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Arrays;

public class ConsumeWebServisRatio {
    RestTemplate restTemplate = new RestTemplate();
    @Value("${urlapikey}")
    private String urlapikey;
    String url = "https://v6.exchangerate-api.com/v6/2d6e1210b20ea181c5a6f08c";

    public BigDecimal currienciesRatio(@PathVariable String input1, @PathVariable String input2 ) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        PairCurrenciesResponsModel result = restTemplate.getForObject(url+"/pair/"+input1+"/"+input2,PairCurrenciesResponsModel.class);                            //exchange("https://v6.exchangerate-api.com/v6/2d6e1210b20ea181c5a6f08c/latest/USD", HttpMethod.GET, entity, String.class).getBody();

        return result.getConversionRate();

    }
    public String getCurrencyInfo() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        String result = restTemplate.getForObject(url+"/latest/USD",String.class);               //exchange("https://v6.exchangerate-api.com/v6/2d6e1210b20ea181c5a6f08c/latest/USD", HttpMethod.GET, entity, String.class).getBody();

        return result;
    }
}
