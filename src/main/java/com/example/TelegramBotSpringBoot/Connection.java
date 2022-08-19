package com.example.TelegramBotSpringBoot;

import com.example.TelegramBotSpringBoot.service.ConsumeWebServisRatio;
import com.example.TelegramBotSpringBoot.service.ConsumeWebServise;
import com.example.TelegramBotSpringBoot.service.CurrencyCorversionService;
import com.example.TelegramBotSpringBoot.service.CurrencyModeService;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connection {
    static java.sql.Connection myConn;
    static  Statement myStat;

    @Value("${currency_price_name}")
     String currency_price_name;

    @Value("${orginal_target_name}")
     String orginal_target_name;

    @Value("${chat_id_table}")
     String chat_id_table;


    public static Double priceLast(){
        double result = 0;
        try {
            myConn = (java.sql.Connection) DriverManager.getConnection("jdbc:sqlserver://DESKTOP-8SIB0D9;databaseName=currency;encrypt=true;trustServerCertificate=true;", "sa", "password123");
            myStat = (Statement) myConn.createStatement();
            String sqlQuery = "SELECT TOP 1 * FROM currency_price_name_table ORDER BY id DESC";
            ResultSet myRs = myStat.executeQuery(sqlQuery);
            while (myRs.next()) {
                result = myRs.getDouble("price");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }


    public static Double ratioWebServis(){
        String original = null,target = null;
        try {
            myConn = (java.sql.Connection) DriverManager.getConnection("jdbc:sqlserver://DESKTOP-8SIB0D9;databaseName=currency;encrypt=true;trustServerCertificate=true;", "sa", "password123");
            myStat = (Statement) myConn.createStatement();
            ResultSet myRs = myStat.executeQuery("SELECT TOP 1 * FROM original_target_name ORDER BY id DESC");
            while (myRs.next()) {
                original = myRs.getString("original");
                target = myRs.getString("target");

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ConsumeWebServisRatio consumeWebServisRatio = new ConsumeWebServisRatio();
        return  consumeWebServisRatio.currienciesRatio(original,target).doubleValue();

    }

    public static String getCurrencyName(){
        String original = null,target = null;
        try {
            myConn = (java.sql.Connection) DriverManager.getConnection("jdbc:sqlserver://DESKTOP-8SIB0D9;databaseName=currency;encrypt=true;trustServerCertificate=true;", "sa", "password123");
            myStat = (Statement) myConn.createStatement();
            ResultSet myRs = myStat.executeQuery("SELECT TOP 1 * FROM original_target_name ORDER BY id DESC");
            while (myRs.next()) {
                original = myRs.getString("original");
                target = myRs.getString("target");

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return original+"-"+target;
    }


    public static long chatId(){
        long chatId = 0;
        try {
            myConn = (java.sql.Connection) DriverManager.getConnection("jdbc:sqlserver://DESKTOP-8SIB0D9;databaseName=currency;encrypt=true;trustServerCertificate=true;", "sa", "password123");
            myStat = (Statement) myConn.createStatement();
            ResultSet myRs = myStat.executeQuery("SELECT TOP 1 * FROM chat_id_table ORDER BY id DESC");
            while (myRs.next()) {
                chatId = myRs.getLong("chat_id");

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return chatId;
    }


    public static void put(String sql_put){
        try {
            myConn = (java.sql.Connection) DriverManager.getConnection("jdbc:sqlserver://DESKTOP-8SIB0D9;databaseName=currency;encrypt=true;trustServerCertificate=true;", "sa", "password123");
            myStat = (Statement) myConn.createStatement();
            myStat.executeUpdate(sql_put);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}