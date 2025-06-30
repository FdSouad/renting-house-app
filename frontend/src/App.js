import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import HouseList from './components/HouseList';
import HouseForm from './components/HouseForm';

function App() {
  return (
<Router>
      <Routes>
        <Route path="/" element={<HouseList />} />
        <Route path="/add" element={<HouseForm />} />
        <Route path="/edit/:id" element={<HouseForm />} />
      </Routes>
    </Router>
  );
}

export default App;
