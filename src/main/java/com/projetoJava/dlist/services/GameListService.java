package com.projetoJava.dlist.services;

import com.projetoJava.dlist.dto.GameDTO;
import com.projetoJava.dlist.dto.GameListDTO;
import com.projetoJava.dlist.dto.GameMinDTO;
import com.projetoJava.dlist.entities.Game;
import com.projetoJava.dlist.entities.GameList;
import com.projetoJava.dlist.repositories.GameListRepository;
import com.projetoJava.dlist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();
        //Tranforma o objeto Game para GameMinDto - help
        return result.stream().map(x -> new GameListDTO(x)).toList();
    }
}
