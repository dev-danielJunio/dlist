    import React from "react";
    import { Draggable } from "react-beautiful-dnd";
    import { Link } from "react-router-dom";

    interface GameProps {
        game: {
            id: string;
            title: string;
            imgUrl: string;
            year: number;
            shortDescription: string;
        };
        index: number;
    }

    export function Game({ game, index }: GameProps) {
        return (
            <Draggable draggableId={String(game.id)} index={index}>
                {(provided) => (
                    <div key={game.id} className="game-card" draggable="true"
                        ref={provided.innerRef}
                        {...provided.draggableProps}
                        {...provided.dragHandleProps}
                    >
                        <img src={game.imgUrl} alt={game.title} className="game-image" />
                        <div className="game-info">
                            <h2>{game.title}</h2>
                            <p><strong>Ano:</strong> {game.year}</p>
                            <p>{game.shortDescription}</p>
                            <Link to={`/game/${game.id}`} className="details-link">Ver Detalhes</Link>
                        </div>
                    </div>
                )}
            </Draggable>
        )
    }