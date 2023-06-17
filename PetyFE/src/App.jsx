import React from "react";
import DogData from "./components/DogData/DogData";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Login from "./components/Login/Login";
import "./App.css";

function App() {
  return (
    <Router>
      <div className="App">
        <Routes>
          <Route path="/login" element={<Login />} />
          <Route path="/" element={<DogData />} />
          {/* Other routes */}
        </Routes>
      </div>
    </Router>
  );
}

export default App;
