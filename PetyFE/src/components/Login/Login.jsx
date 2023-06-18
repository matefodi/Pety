import React, { useState } from "react";

function Login() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [loginStatus, setLoginStatus] = useState("");

  const handleLogin = (event) => {
    event.preventDefault();

    // Replace with your login logic
    if (username === "user" && password === "password") {
      setLoginStatus("Login successful");
    } else {
      setLoginStatus("Login failed");
    }

    // Reset the input fields
    setUsername("");
    setPassword("");
  };

  return (
    <div>
      <h1>Login</h1>
      <form onSubmit={handleLogin}>
        <div>
          <label htmlFor="username">Username:</label>
          <input
            type="text"
            id="username"
            value={username}
            onChange={(event) => setUsername(event.target.value)}
          />
        </div>
        <div>
          <label htmlFor="password">Password:</label>
          <input
            type="password"
            id="password"
            value={password}
            onChange={(event) => setPassword(event.target.value)}
          />
        </div>
        <button type="submit">Login</button>
      </form>
      <p>{loginStatus}</p>
    </div>
  );
}

export default Login;
