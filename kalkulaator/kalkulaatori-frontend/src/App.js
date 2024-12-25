//import logo from './logo.svg';
import { Link, Route, Routes } from 'react-router-dom';
import './App.css';

import Sonad from './pages/Sonad';
import Numbrid from './pages/Numbrid';
import Komakohaga from './pages/Komakohaga';
import Lause from './pages/Lause';
import Toiduained from './pages/Toiduained';
import Mang from './pages/Mang';

function App() {

  return (
    <div className="App">
      <Link to="/Sonad">
        <button>Sõnad</button>
      </Link>
      <Link to="/Numbrid">
       <button>Numbrid</button>
      </Link>
      <Link to="/Komakohaga">
        <button>Komakohaga</button>
      </Link>
      <Link to="/Lause">
        <button>Lause</button>
      </Link>
      <Link to="/Toiduained">
        <button>Toiduained</button>
      </Link>
      <Link to="/Mang">
        <button>Mäng</button>
      </Link>

      <Routes>
        <Route path="Numbrid" element={<Numbrid/>}/>
        <Route path="Sonad" element={<Sonad/>}/>
        <Route path="Komakohaga" element={<Komakohaga/>}/>
        <Route path="Lause" element={<Lause/>}/>
        <Route path="Toiduained" element={<Toiduained/>}/>
        <Route path="Mang" element={<Mang/>}/>
      </Routes>
      
    </div>
  );
}

export default App;
