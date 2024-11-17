package com.projetoJava.dlist.services;

import com.projetoJava.dlist.dto.GameMinDTO;
import com.projetoJava.dlist.entities.Game;
import com.projetoJava.dlist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll();
        //Tranforma o objeto Game para GameMinDto
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }
}
