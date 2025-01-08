import React from "react";
import { Link } from "react-router-dom";

interface GameProps {
    game: {
      id: string;
      title: string;
      imgUrl: string;
      year: number;
      shortDescription: string;
    };
  }

export function Game({game}: GameProps){
    return(
        <div key={game.id} className="game-card" draggable="true"> 
            <img src={game.imgUrl} alt={game.title} className="game-image"/>
            <div className="game-info">
              <h2>{game.title}</h2>
              <p><strong>Ano:</strong> {game.year}</p>
              <p>{game.shortDescription}</p>
              <Link to={`/game/${game.id}`} className="details-link">Ver Detalhes</Link>
            </div>
          </div>
    )
}