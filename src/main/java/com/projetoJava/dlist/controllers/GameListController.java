package com.projetoJava.dlist.controllers;

import com.projetoJava.dlist.dto.GameDTO;
import com.projetoJava.dlist.dto.GameListDTO;
import com.projetoJava.dlist.dto.GameMinDTO;
import com.projetoJava.dlist.entities.GameList;
import com.projetoJava.dlist.services.GameListService;
import com.projetoJava.dlist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @GetMapping
    public List<GameListDTO> findAll() {
        return gameListService.findAll();
    }

}
