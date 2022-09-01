package com.example.TelegramBotSpringBoot.Table;

import com.example.TelegramBotSpringBoot.Table.ChatIdTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatIdTableRepository extends JpaRepository<ChatIdTable,Long> {
    public String findByChatId(String chatId);
}
