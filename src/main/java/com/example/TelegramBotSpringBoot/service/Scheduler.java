package com.example.TelegramBotSpringBoot.service;

import com.example.TelegramBotSpringBoot.Connection;
import com.example.TelegramBotSpringBoot.Currency;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.math.BigDecimal;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Component
public class Scheduler {
    @Scheduled(cron = "0 * * * * *")
    public void sendMessage() {

        double lastPrice = Connection.priceLast();
        double newPrice = Connection.ratioWebServis();
        long chatId = Connection.chatId();

        if(lastPrice<newPrice*0.95|| lastPrice>newPrice*1.05){
            Message message;

            SendMessage.builder()
                    .chatId(chatId)
                    .text("new price: "+newPrice)
                    .build();
            String sql_put= "insert into currency_price_name_table" +
                    "(currency_name,price)" +
                    "values" +
                    "('"+Connection.getCurrencyName()+"',"+newPrice+")";
            Connection.put(sql_put);
        }

    }
}
