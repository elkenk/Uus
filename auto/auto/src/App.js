
import { Link, Route, Routes } from 'react-router-dom';
import './App.css';
import Toiduaine from './pages/Toiduaine';
import Toit from './pages/Toit';
import Personal from './pages/Personal';
import Auto from './pages/Auto';


function App() {
  return (
    <div className="App">
        <Link to="/Auto">
        <button>Auto</button>
      </Link>
      <Link to="/Personal">
       <button>Personal</button>
      </Link>
      <Link to="/Toit">
        <button>Toidud</button>
      </Link>
      <Link to="/Toiduaine">
        <button>Toiduained</button>
      </Link>
     
      <Routes>
        <Route path="Auto" element={<Auto/>}/>
        <Route path="Personal" element={<Personal/>}/>
        <Route path="Toit" element={<Toit/>}/>
        <Route path="Toiduaine" element={<Toiduaine/>}/>
      </Routes>
    </div>
  );
}

export default App;
