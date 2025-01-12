import { useEffect, useState } from 'react';
import './index.css'
import api from '../services/api'
import { Game } from './game'
import { DragDropContext, Droppable } from 'react-beautiful-dnd';

const Home = () => {
  const [games, setGames] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState([]);
  const [listId, setListId] = useState(2);
  async function getGames(){
    try {
      const gamesFromApi = await api.get(`/lists/${listId}/games`);
      setGames(gamesFromApi.data);
      setLoading(false);
      setError(false);
    } catch (error) {
      setLoading(false);
      setError("Erro ao carregar jogos, por favor tente novamente.");
    }
  }

  useEffect(() => {
    getGames()
  }, [listId])

  if(loading){
    return <p>Carregando...</p>;
  }
   
  if (error) {
    return <h4 className="error-message">{error}</h4>;
  }

  const reorder = (list, startIndex, endIndex) => {
    const result = Array.from(list);
    const [removed] = result.splice(startIndex, 1);
    result.splice(endIndex, 0, removed);
  
    return result;
  };

  async function onDragEnd(result){
    if(!result.destination) return;

    const items = reorder(games,result.source.index,result.destination.index);
    setGames(items);

    try {
      await api.post(`/lists/${listId}/replacement`, {
        sourceIndex: result.source.index,
        destinationIndex: result.destination.index,
      });
      console.log("Ordem atualizada no servidor");
    } catch (error) {
      console.error("Erro ao atualizar a ordem no servidor", error);
      setGames(reorder(items, result.destination.index, result.source.index));
    }

  }

  const handlePageChange = (page) => {
    setListId(page);
  };

  return (
    <>
      <div className="home-container">
      <h1>Jogos Populares</h1>
      <DragDropContext onDragEnd={onDragEnd}>
        <Droppable droppableId='games' type='list' direction='vertical'>
          {(provided) => (
            <div className="game-list"
                {...provided.droppableProps} ref={provided.innerRef}>
              {games.map((game, index) => (
                <Game key={game.id} game={game} index={index}/>
              ))}
            {provided.placeholder}
            </div>
          )}
        </Droppable>
      </DragDropContext>

      <div className="pagination">
        {[1, 2].map((page) => (
          <button
            key={page}
            className={`pagination-button ${listId === page ? 'active' : ''}`}
            onClick={() => handlePageChange(page)}
          >
            {page}
          </button>
        ))}
      </div>

    </div>
    </>
  )
}

export default Home
