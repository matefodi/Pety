import React, { useState } from "react";
import axios from "axios";
import "./LoginForm.css";

function LoginForm() {
  const handleLogin = async () => {
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    try {
      await axios.post("http://localhost:8000/XD", { email, password });
      window.location.href = "http://localhost:8000/XD";
    } catch (error) {
      console.error("Login error:", error);
    }
  };

  const handleRegister = () => {
    window.location.href = "http://localhost:3000/register";
  };

  return (
    <div className="login-page">
      <div className="bg-image"></div>
      <div className="login-card">
        <h3>Login</h3>
        <div className="form-group">
          <label>Email address</label>
          <input
            type="email"
            className="form-control"
            placeholder="Enter email"
          />
        </div>
        <div className="form-group">
          <label>Password</label>
          <input
            type="password"
            className="form-control"
            placeholder="Enter password"
          />
        </div>
        <div className="buttons">
          <button onClick={handleLogin} className="login-btn">
            Login
          </button>
          <button onClick={handleRegister} className="register-btn">
            Register
          </button>
        </div>
      </div>
    </div>
  );
}

export default LoginForm;
