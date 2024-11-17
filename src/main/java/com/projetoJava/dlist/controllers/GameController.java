package com.projetoJava.dlist.controllers;

import com.projetoJava.dlist.dto.GameMinDTO;
import com.projetoJava.dlist.entities.Game;
import com.projetoJava.dlist.repositories.GameRepository;
import com.projetoJava.dlist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameMinDTO> findAll() {
        return gameService.findAll();
    }

}
