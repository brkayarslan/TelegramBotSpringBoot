package com.example.TelegramBotSpringBoot;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Currency {
    USD(0),EUR(2),TRY(3),GPB(4),CHF(5),CNY(6),JPY(7),SAR(8);

    private final int id;
}
