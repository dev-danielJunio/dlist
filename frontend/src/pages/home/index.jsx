import { useEffect, useState } from 'react';
import { Link } from 'react-router-dom'; 
import './style.css'
import api from '../services/api'
import { Game } from './game'

const Home = () => {
  const [games, setGames] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState([]);

  async function getUser(){
    try {
      const gamesFromApi = await api.get('/games');
      setGames(gamesFromApi.data);
      setLoading(false);
      setError(false);
    } catch (error) {
      setLoading(false);
      setError("Erro ao carregar jogos, por favor tente novamente.");
    }
  }

  useEffect(() => {
    getUser()
  }, [])

  if(loading){
    return <p>Carregando...</p>;
  }
   
  if (error) {
    return <h4 className="error-message">{error}</h4>;
  }

  return (
    <>
      <div className="home-container">
      <h1>Jogos Populares</h1>
      <div className="game-list">
        {games.map((game) => (
          <Game key={game.id} game={game}/>
        ))}
      </div>
    </div>
    </>
  )
}

export default Home
