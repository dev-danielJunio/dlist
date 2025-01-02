package com.projetoJava.dlist.services;

import com.projetoJava.dlist.GameMinProjection;
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

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();
        //Tranforma o objeto Game para GameMinDto - help
        return result.stream().map(x -> new GameListDTO(x)).toList();
    }

    @Transactional(readOnly = true)
    public void move(Long listId, int sourceIndex, int destinationIndex){
        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = Math.min(sourceIndex, destinationIndex);
        int max = Math.max(sourceIndex, destinationIndex);

        for(int i = min; i <= max; i++){
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }

    }

}
