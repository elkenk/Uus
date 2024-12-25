import './App.css';
import Mang from './components/Mang';
import Sportlane from './components/Sportlane';
import Tulemus from './components/Tulemus';

function App() {
  return (
    <div className="App">
      <Sportlane/>  <Tulemus/>
      <br/>
      <hr/>
      <hr/>
      <br/>
      <Mang/>
    </div>
  );
}

export default App;
