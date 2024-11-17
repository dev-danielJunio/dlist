package com.projetoJava.dlist.services;

import com.projetoJava.dlist.dto.GameDTO;
import com.projetoJava.dlist.dto.GameMinDTO;
import com.projetoJava.dlist.entities.Game;
import com.projetoJava.dlist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    //Transactional para ficar transasional(atomica, consistente, isolada e duravel)
    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll();
        //Tranforma o objeto Game para GameMinDto - help
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }
}
