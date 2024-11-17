package com.projetoJava.dlist.repositories;

import com.projetoJava.dlist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
