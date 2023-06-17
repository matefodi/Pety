import React, { useState, useEffect } from "react";
import axios from "axios";
import "./DogData.css";

function DogData() {
  const [dogData, setDogData] = useState([]);

  useEffect(() => {
    getDogData();
  }, []);

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

  const deleteDog = (dogId) => {
    axios
      .delete(`http://localhost:8080/dog/${dogId}`)
      .then(() => {
        // After successful deletion, fetch the updated dog data
        getDogData();
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <div>
      <h1>Dog Information</h1>

      <div className="dog-container">
        {dogData.length > 0 ? (
          dogData.map((dog) => (
            <div className="dog-card" key={dog.id}>
              <h2>Name: {dog.name}</h2>
              <p>Breed: {dog.breed}</p>
              <p>Age: {dog.age}</p>
              <button onClick={() => deleteDog(dog.id)}>Delete</button>
            </div>
          ))
        ) : (
          <p>No dogs found.</p>
        )}
      </div>
    </div>
  );
}

export default DogData;
