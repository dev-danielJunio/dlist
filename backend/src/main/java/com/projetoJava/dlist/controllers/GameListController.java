package com.projetoJava.dlist.controllers;

import com.projetoJava.dlist.dto.GameDTO;
import com.projetoJava.dlist.dto.GameListDTO;
import com.projetoJava.dlist.dto.GameMinDTO;
import com.projetoJava.dlist.dto.ReplacementDTO;
import com.projetoJava.dlist.entities.GameList;
import com.projetoJava.dlist.services.GameListService;
import com.projetoJava.dlist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
@CrossOrigin(origins = "http://localhost:5173")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll() {
        return gameListService.findAll();
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId) {
        return gameService.findByList(listId);
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }


}
