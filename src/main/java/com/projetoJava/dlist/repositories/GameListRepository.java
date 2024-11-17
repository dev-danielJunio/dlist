package com.projetoJava.dlist.repositories;

import com.projetoJava.dlist.entities.Game;
import com.projetoJava.dlist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
