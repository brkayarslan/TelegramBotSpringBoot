package com.example.TelegramBotSpringBoot.Table;

import javax.persistence.*;

@Entity
@Table(name="orginal_target_name")
public class OriginalTargetNameTable {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String original;
    private String target;

    public OriginalTargetNameTable() {
    }

    public OriginalTargetNameTable(String original, String target) {
        this.original = original;
        this.target = target;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
