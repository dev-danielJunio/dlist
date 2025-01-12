import ReactDOM from 'react-dom/client';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Home from './pages/home';
import GameDetails from './pages/home/gameDetail';
import '../src/index.css'


export default function App() {
  return(
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} /> 
        <Route path="/game/:id" element={<GameDetails />} />
      </Routes>
    </BrowserRouter>
  )

}

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<App />);
