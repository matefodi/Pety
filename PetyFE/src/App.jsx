import React, { useState } from "react";
import axios from "axios";
import "./App.css";

function App() {
  const [dogData, setDogData] = useState([]);

  const getDogData = () => {
    axios
      .get("http://localhost:8080/dog")
      .then((response) => {
        setDogData(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <div className="App">
      <h1>Dog Information</h1>
      <button onClick={getDogData}>Get Dog Data</button>

      <div className="dog-container">
        {dogData.length > 0 &&
          dogData.map((dog) => (
            <div className="dog-card" key={dog.id}>
              <h2>Name: {dog.name}</h2>
              <p>Breed: {dog.breed}</p>
              <p>Age: {dog.age}</p>
            </div>
          ))}
      </div>
    </div>
  );
}

export default App;
