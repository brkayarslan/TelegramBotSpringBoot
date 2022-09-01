package com.example.TelegramBotSpringBoot.Table;

import javax.persistence.*;

@Entity
@Table(name="chat_id_table")
public class ChatIdTable {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String chatId;
    private String name;

    public ChatIdTable() {
    }

    public ChatIdTable(String chatId, String name) {
        this.chatId = chatId;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChat_id() {
        return chatId;
    }

    public void setChat_id(String chat_id) {
        this.chatId = chat_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
