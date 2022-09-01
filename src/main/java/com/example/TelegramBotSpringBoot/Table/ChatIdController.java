package com.example.TelegramBotSpringBoot.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ChatIdController {
    @Autowired
    private ChatIdTableRepository chatIdTableRepository;

    @GetMapping("/chat_id_table")
    public String listAll(Model model){
        List<ChatIdTable> chatIdTableList = chatIdTableRepository.findAll();
        model.addAttribute("chatIdTableList",chatIdTableList);

        return "chat_id_table";
    }
}
