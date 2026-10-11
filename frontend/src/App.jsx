import { BrowserRouter } from 'react-router-dom';
import './App.css';
import Home from './pages/Home';
import Navbar from './pages/Navbar';
import Footer from './pages/Footer';

function App() {

  return (
    <div className='h-screen flex flex-col'>
      <Navbar />
      <div className='w-full flex-1 min-h-0 overflow-y-auto'>
        <Home />
        <Footer />
      </div>
    </div>
  );
}

export default App;