import { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom'; // Para acessar os parâmetros da URL
import api from '../services/api'; // Supondo que você tenha um arquivo api.js para fazer as requisições

const GameDetails = () => {
  const { id } = useParams() //help
  const [game, setGame] = useState([])
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState([]);

  async function getGameDetails() {
    try {
      const response = await api.get(`/games/${id}`);
      setGame(response.data)
      setLoading(false);
      setError(false);
    } catch (error) {
      setLoading(false);
      setError("Erro ao carregar os detalhes do jogo, tente novamente mais tarde");
    }
  }

  useEffect(() => {
    getGameDetails()
  }, [id]);

  if(loading){
    return <p>Carregando...</p>;
  }
   
  if (error) {
    return <h4 className="error-message">{error}</h4>;
  }

  return (
    <div className="game-details">
      <h1>{game.title}</h1>
      <img src={game.imgUrl} alt={game.title} className="game-image"/>
      <p><strong>Ano:</strong> {game.year}</p>
      <p>{game.longDescription}</p>
      <p><strong>Gênero:</strong> {game.genre}</p>
      <p><strong>Plataforma:</strong> {game.platforms}</p>
    </div>
  );
}

export default GameDetails
