package com.competition.competition.controller;

import com.competition.competition.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/card")
public class CardController {

    @Autowired
    private CardService cardService;
}
